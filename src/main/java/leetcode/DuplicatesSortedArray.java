package leetcode;

/*
 * Problem: Remove Duplicates from Array
 * Remove duplicate elements and return unique elements in sorted order.
 *
 * Input: An array of integers with duplicates
 * Output: Unique elements in sorted order
 *
 * Example:
 *   Input: {1, 2, 3, 6, 3, 6, 1}
 *   Output: {1, 2, 3, 6}
 *
 * Memory Trick:
 *   "TreeSet = unique + sorted automatically"
 *   - TreeSet removes duplicates AND keeps sorted order
 *   - Collectors.toCollection(TreeSet::new)
 *
 *   Alternatives:
 *   - HashSet: unique only (no order)
 *   - LinkedHashSet: unique + insertion order
 *   - TreeSet: unique + sorted order
 *
 * Time Complexity: O(n log n) - TreeSet insertion is O(log n)
 * Space Complexity: O(n) - TreeSet stores unique elements
 */
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DuplicatesSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 3, 6, 1};
        Arrays.stream(arr).boxed().collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
    }
}
