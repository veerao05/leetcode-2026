package java8;

/*
 * Java 8 Stream API Examples
 * Comprehensive collection of common Stream operations.
 *
 * Topics Covered:
 * - Filtering (filter)
 * - Mapping (map, mapToObj)
 * - Finding (findFirst, findAny)
 * - Counting (count)
 * - Min/Max operations
 * - Grouping (groupingBy)
 * - Sorting (sorted, reverseOrder)
 * - Distinct elements
 * - String character operations
 * - List/Array conversions
 *
 * Time Complexity: O(n) for most single-pass operations
 * Space Complexity: O(n) for collecting to new collections
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Java8Example {
    public static void main(String[] args) {


        int[] arr = new int[]{9, 10, 15, 8, 49, 25, 98, 32, 10};
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        // 1. to filter even nos from list
        System.out.println("Even nos from the list");
        list.stream().filter(i -> i % 2 == 0).distinct().forEach((k) -> System.out.println(k + " "));
        System.out.println("Even nos from the array");
        Arrays.stream(arr).boxed().filter(i -> i % 2 == 0).distinct().forEach((k) -> System.out.println(k + " "));

        System.out.println("starts with 2");
        Arrays.stream(arr).filter(e -> String.valueOf(e).startsWith("2")).forEach(System.out::println);

        // 2.Given a list of integers, find out all the numbers starting with 1 using Stream functions
        System.out.println("starts with 1 from the list");
        list.stream().map(s -> s + " ").filter(s -> s.startsWith("1")).distinct().forEach((k) -> System.out.println(k + " "));
        System.out.println("starts with 1 from the arr");
        Arrays.stream(arr).boxed().map(s -> s + " ").filter(s -> s.startsWith("1")).distinct().forEach((k) -> System.out.println(k + " "));

        // 3 .How to find duplicate elements in a given integers list in java using Stream functions
        Set<Integer> set = new HashSet<>();
        System.out.println("Duplicate elements removed");
        list.stream().filter(s -> !set.add(s)).forEach((k) -> System.out.println(k + " "));
        Arrays.stream(arr).boxed().filter(s -> !set.add(s)).forEach((k) -> System.out.println(k + " "));

        // 4 .Given the list of integers, find the first element of the list using Stream functions
        System.out.println("first element of the list using Stream functions");
        list.stream().findFirst().ifPresent(System.out::println);
        Arrays.stream(arr)
                .boxed()
                .findFirst()
                .ifPresent(System.out::println);


        // 5 .Given a list of integers, find the total number of elements present in the list using Stream functions
        System.out.println("size of list::" + (long) list.size());
        System.out.println("size of list::" + Arrays.stream(arr).count());

        // 6.find the maximum value element present in it using Stream functions
        System.out.println("max element in the list::" + list.stream()
                .max(Integer::compare)
                .get());
        System.out.println("max element in the list::" + Arrays.stream(arr).max()
                .getAsInt());

        // 7. find the first non-repeated character in it using Stream functions
        String input = "Java articles are Awesome";
        Character character = input.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("first non-repeated character::" + character);

        // 8.Given a String, find the first repeated character in it using Stream functions
        Character repeatedCharacter = input.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("first repeated character::" + repeatedCharacter);

        // 9. a list of integers, sort all the values present in it using Stream functions
        System.out.println("list of integers, sort all the values");
        list.stream().sorted().distinct().forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted().forEach(System.out::println);

        // 10.Given a list of integers, sort all the values present in it in
        // descending order using Stream functions
        System.out.println("list of integers, sort all the values in desc");
        list.stream().sorted(Collections.reverseOrder()).distinct().forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).distinct().forEach(System.out::println);

        boolean duplicates = list.stream().distinct().count() < list.size();
        System.out.println("Duplicates exists?::" + duplicates);

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
        concatStream.forEach(System.out::println);

        //14. Java 8 program to perform cube on list elements and filter numbers greater than 50
        System.out.println("cube on list elements and filter numbers greater than 50");
        list.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

        list.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

        // 15. Write a Java 8 program to sort an array and then convert the sorted array into Stream
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        //16 . How to use map to convert object into Uppercase in Java 8
        List<String> names = Arrays.asList(new String[]{"Aa", "Bb", "Cc", "Dd", "Aa"});
        names.stream().map(String::toLowerCase).forEach(System.out::println);

        //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
        List<String> duplicateNames = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Alice", "David");
        Map<String, Long> dupNames = duplicateNames.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        System.out.println("Duplicate names::" + dupNames);

        // 18. How to find only duplicate elements with its count from the String ArrayList in Java8
        System.out.println("Duplicate names more than 1::");
        duplicateNames.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);

        //19. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?

        List<Integer> nodesList = new ArrayList<>();
        nodesList.add(1);
        nodesList.add(2);

        Optional<List<Integer>> latestList = Optional.ofNullable(nodesList);
        // Just check if present and print
        latestList.ifPresent(System.out::println);

        //20. Program to find the Maximum element in an array
        System.out.println(list.stream().min(Integer::compare).get());
        System.out.println(Arrays.stream(arr).min().getAsInt());

        //21. program to print the count of each character in a String?
        String str = "string data to count each character";
        Map<String, Long> strMap = Arrays.stream(str.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(str1 -> str1, LinkedHashMap::new, Collectors.counting()));

    }
}
