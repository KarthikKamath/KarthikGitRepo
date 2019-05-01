package kk.learn.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        Supplier<Person> createPerson1 = () -> new Person("John", 30);
        Supplier<Person> createPerson2 = Person::new;
        printPerson1.accept(createPerson1.get());
        printPerson1.accept(createPerson2.get());

        // Function category
        Function<Person, String> getPersonDetails = person -> person.toString();
//        getPersonDetails.apply()
    }
}
