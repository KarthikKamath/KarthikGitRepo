package kk.learn.lambda;

import java.util.Comparator;
import java.util.function.Function;

public class ComparatorUser
{

    public static void main (String[] args)
    {
        CustomComparator<Person> compareAge = (p1, p2) -> p1.getAge() - p2.getAge();
        CustomComparator<Person> compareName = (p1, p2) -> p1.getName().compareTo(p2.getName());


        CustomComparator.compareUsing(Person::getName);
        CustomComparator.compareUsing(Person::getAge);

    }
}



@FunctionalInterface
interface CustomComparator<T> extends Comparator<T> {

    static CustomComparator compareUsing(Function<Person, ? extends Comparable> f) {

        CustomComparator<Person> compareThis = (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));

        return compareThis;
    }

}
