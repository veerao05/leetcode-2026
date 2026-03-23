package leetcode.arrays;

/*
 * Problem: Remove Duplicates and Sort Array
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
 *   "TreeSet = Unique + Sorted in one shot"
 *   - TreeSet automatically removes duplicates
 *   - TreeSet keeps elements sorted
 *   - Collectors.toCollection(TreeSet::new)
 *
 *   Compare Set types:
 *   - HashSet: unique, no order
 *   - LinkedHashSet: unique, insertion order
 *   - TreeSet: unique, sorted order
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
        Arrays.stream(arr).boxed()
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println);
    }
}
