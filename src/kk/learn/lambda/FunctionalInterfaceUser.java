package kk.learn.lambda;

import java.util.function.*;

public class FunctionalInterfaceUser {


    public static void main(String[] args)
    {
        /* FunctionalInterfaces categories: */

        // Consumer category
        Person danny = new Person("Danny", 35);
        Consumer<Person> printPerson1 = person -> System.out.println(person.toString());
        printPerson1.accept(danny);
        Consumer<Person> printPerson2 = System.out::println;
        printPerson2.accept(danny);

        BiConsumer<Person, Integer> updatePersonAge = (person, newAge) -> person.setAge(newAge);
        updatePersonAge.accept(danny, 36);
        printPerson1.accept(danny);

        BiConsumer<Person, Integer> updatePersonAge2 = Person::setAge;
        updatePersonAge2.accept(danny, 37);
        printPerson2.accept(danny);


        // Producer category
        Supplier<Person> createPerson = () -> new Person("Angelica", 30);
        Supplier<Person> createPerson2 = Person::new;
        Person angelica = createPerson.get();
        printPerson1.accept(angelica);
        printPerson1.accept(createPerson2.get());

        // Function category
        Function<Person, String> getPersonDetails = person -> person.toString();
        System.out.println(getPersonDetails.apply(danny));

        BiFunction<Person, Integer, String >
                updatePersonAgeAnfGetDetails = (person, newAge) -> {
                                                    person.setAge(newAge);
                                                    return person.toString();
                                                };
        System.out.println(updatePersonAgeAnfGetDetails.apply(danny, 40));

        UnaryOperator<Person> makeSeniorCitizen = person ->
        {
            person.setName("Sr. " + person.getName());
            person.setAge(60);
            return person;
        };
        makeSeniorCitizen.apply(danny);
        System.out.println(danny);

        BinaryOperator<Person> createChild = (person1, person2) ->
        {
            Person child = new Person("Child of " + person1.getName() + " and " + person2.getName(), 1);
            return child;
        };
        Person child = createChild.apply(danny, angelica);
        System.out.println(child);

        //Predicate category
        Predicate<Person> isAdult = person ->
        {
            return person.getAge() > 17;
        };
        Predicate<Person> isSeniorCitizen = person ->
        {
        return person.getAge() > 59;
        };
        System.out.println("Is Danny adult: " + isAdult.test(danny));
        System.out.println("Is Danny senior: " + isAdult.and(isSeniorCitizen).test(danny));
        System.out.println("Is Angelica senior: " + isAdult.and(isSeniorCitizen).test(angelica));

        BiPredicate<Person, Integer> isSuperSenior = (person, superAge) ->
            isAdult.test(person) && person.getAge() >= superAge;
        System.out.println("Is Danny super senior: " + isSuperSenior.test(danny, 80));

    }
}
