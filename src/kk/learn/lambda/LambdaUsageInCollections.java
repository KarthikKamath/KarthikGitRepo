package kk.learn.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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

        //MAP
        System.out.println("-----\nMap");

        Map<String, Integer> mapNameToAge = new HashMap<String, Integer>() {
        {
            put("Ritika", 5);
            put("Rekha", 32);
            put("Karthik", 35);
        }};
        //forEach
        BiConsumer<String, Integer> printMapEntry = (key, value) -> {
            System.out.println(key + " is of age: " + value);
        };
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\ngetOrDefault");
        //getOrDefault
        System.out.println(mapNameToAge.getOrDefault("Unknown", -1));
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nputIfAbsent");
        mapNameToAge.putIfAbsent("Unknown", 0);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nreplace1");
        mapNameToAge.replace("Unknown", 1);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nreplace2");
        mapNameToAge.replace("Unknown", 1,2);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nreplaceAll");
        mapNameToAge.replaceAll((name, age) -> age +10);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nremove");
        mapNameToAge.remove("Unknown", 11);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\ncompute");
        mapNameToAge.compute("Unknown", (name, age) -> age +10 );
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\ncomputeIfAbsent");
        mapNameToAge.computeIfAbsent("Unknown2", ( age) -> 50);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\ncomputeIfPresent");
        mapNameToAge.computeIfPresent("Unknown2", (name, age) -> 5);
        mapNameToAge.forEach(printMapEntry);

        System.out.println("-----\nMerge");

        mapNameToAge.merge("KK", 50, (name, value) -> 50);
        mapNameToAge.forEach(printMapEntry);

        mapNameToAge.merge("Karthik", 50, (name, value) -> 55);
        mapNameToAge.forEach(printMapEntry);
    }
}
