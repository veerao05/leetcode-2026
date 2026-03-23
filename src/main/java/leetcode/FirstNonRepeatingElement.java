package leetcode;

/*
 * Problem: First Unique Element (First Non-Repeating)
 * Find the first element that appears exactly once in the array.
 *
 * Input: An array of integers
 * Output: The first element that doesn't repeat
 *
 * Example:
 *   Input: {10, 5, 3, 4, 3, 5, 6}
 *   Output: 10 (first unique element)
 *
 * Memory Trick:
 *   "LinkedHashMap + count == 1"
 *   - Same pattern as FirstRepeating, but filter count == 1
 *   - LinkedHashMap preserves insertion order!
 *
 *   Pattern: groupingBy → filter(count == 1) → findFirst
 *   Compare: Repeating uses count > 1, NonRepeating uses count == 1
 *
 * Time Complexity: O(n) - Single pass to count, single pass to find
 * Space Complexity: O(n) - LinkedHashMap stores element counts
 */
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity()
                        , LinkedHashMap::new
                        , Collectors.counting())).entrySet()
                .stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
