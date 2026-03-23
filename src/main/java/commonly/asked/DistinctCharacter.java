package commonly.asked;

/*
 * Problem: Find Distinct (Non-Repeating) Characters
 * Find all characters that appear exactly once in the string.
 * Case-insensitive comparison.
 *
 * Input: A string
 * Output: Characters that appear only once
 *
 * Example:
 *   Input: "abcdABCDabcde"
 *   Output: e (only 'e' appears once after case-insensitive grouping)
 *
 * Memory Trick:
 *   "Count → Filter count == 1"
 *   - Convert to lowercase for case-insensitive
 *   - groupingBy(identity, counting) → map of char→count
 *   - filter(count == 1) → unique chars only
 *
 *   Pattern: chars() → mapToObj → groupingBy → filter → map
 *
 * Time Complexity: O(n) - Single pass to count characters
 * Space Complexity: O(k) - Map stores unique characters
 */
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctCharacter {

    public static void main(String[] args) {
        String str = "abcdABCDabcde";
        str.chars().mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).forEach(System.out::println);
    }
}
