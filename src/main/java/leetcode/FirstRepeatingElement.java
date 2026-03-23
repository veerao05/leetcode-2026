package leetcode;

/*
 * Problem: First Repeating Element
 * Find the first element that appears more than once in the array.
 *
 * Input: An array of integers
 * Output: The first element that repeats
 *
 * Example:
 *   Input: {10, 5, 3, 4, 3, 5, 6}
 *   Output: 5 (first element to have a duplicate)
 *
 * Memory Trick:
 *   "LinkedHashMap preserves insertion order"
 *   - Count frequencies with LinkedHashMap (keeps order!)
 *   - Filter where count > 1
 *   - findFirst() gives first repeated element
 *
 *   Key: LinkedHashMap (not HashMap) to maintain order
 *   Pattern: groupingBy → filter → findFirst
 *
 * Time Complexity: O(n) - Single pass to count, single pass to find
 * Space Complexity: O(n) - LinkedHashMap stores element counts
 */
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity()
                        , LinkedHashMap::new
                        , Collectors.counting())).entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
