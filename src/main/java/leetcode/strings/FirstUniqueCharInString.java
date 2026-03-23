package leetcode.strings;

/*
 * Problem: First Unique Character in String (LeetCode 387)
 * Find the index of the first non-repeating character in a string.
 *
 * Input: A string
 * Output: Index of first unique character, or -1 if none
 *
 * Example:
 *   Input: "loveleetcode"
 *   Output: 2 (character 'v' at index 2)
 *
 *   Input: "leetcode"
 *   Output: 0 (character 'l' at index 0)
 *
 * Approach (Java 8 Streams):
 *   - Count character frequencies with LinkedHashMap
 *   - Filter where count == 1
 *   - findFirst() gives first unique char
 *
 * Memory Trick:
 *   "LinkedHashMap + count == 1 + findFirst"
 *   - LinkedHashMap preserves insertion order!
 *   - Same pattern as FirstNonRepeatingElement
 *   - groupingBy → filter(count == 1) → findFirst
 *
 * Time Complexity: O(n) - Two passes through string
 * Space Complexity: O(1) - At most 26 characters (constant)
 */
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharInString {
    public static void main(String[] args) {
        String str = "loveleetcode";
        str.chars().mapToObj(s -> Character.toLowerCase((char) s)).collect(
                        Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting())).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst().ifPresent(System.out::println);

    }
}
