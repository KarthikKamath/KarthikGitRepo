package kk.learn.lambda;

import java.util.*;

public class LambdaUsageInCollections {

    public static void main(String[] args)
    {
        // COLLECTIONS
        Collection<String> collectNames = new LinkedList<>();
        Collections.addAll(collectNames, "Karthik", "Rekha", "Ritika");
        //ForEach
        collectNames.forEach(System.out::println);
//        collectNames.stream().map(name -> name + " Kamath").forEach(System.out::println);
        System.out.println("-----");

        // RemoveIf
        collectNames.removeIf(name -> name.equalsIgnoreCase("karthik"));
        collectNames.forEach(System.out::println);
        System.out.println("-----");
        System.out.println("List\n-----");

        // LIST
        List<String> collectNamesInList = new LinkedList<>();
        Collections.addAll(collectNamesInList, "Rekha", "Karthik", "Ritika");
        // replaceALl
        collectNamesInList.replaceAll(name -> name + " Kamath");
        collectNamesInList.forEach(System.out::println);
        System.out.println("-----\nSort");
        // sort (Comparator.comparing.thenCompare.reversed)

        collectNamesInList.sort((e1, e2) -> e1.compareTo(e2));
        collectNamesInList.forEach(System.out::println);
        System.out.println("-----\nNautral order");

        collectNamesInList.sort(Comparator.naturalOrder());
        collectNamesInList.forEach(System.out::println);

        System.out.println("-----\nReverse order");
        Comparator<String> reverseOrder = (p1, p2) -> p2.compareTo(p1);
        Comparator<String> naturalOrder = (p1, p2) -> p1.compareTo(p2);
        collectNamesInList.sort(reverseOrder.thenComparing(naturalOrder));
        collectNamesInList.forEach(System.out::println);

        //.thenComparing(Comparator.reverseOrder())

        //MAP
        //forEach
        //getOrDefault
        //putIfPresent
        //replace - 2 versions
        //replaceAll
        //remove
        //compute
        //computeIfAbsent
        //computeIfPresent
        //merge


    }
}
