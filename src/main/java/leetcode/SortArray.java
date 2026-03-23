package leetcode;

/*
 * Problem: Sort Array in Descending Order
 * Sort an array of integers in descending (reverse) order.
 *
 * Input: An array of integers
 * Output: Elements printed in descending order
 *
 * Example:
 *   Input: {78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65}
 *   Output: 90, 78, 55, 34, 34, 20, 6, 3, 1, -1, -4, -65
 *
 * Memory Trick:
 *   "sorted(reverseOrder())" for descending
 *   - For int[]: Use Integer[] or boxed() stream
 *   - Arrays.stream(arr).sorted(reverseOrder())
 *
 *   Alternative: sorted(Comparator.reverseOrder())
 *   Note: Primitives don't support reverseOrder directly
 *
 * Time Complexity: O(n log n) - Uses TimSort algorithm
 * Space Complexity: O(n) - Stream creates intermediate objects
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SortArray {
    public static void main(String[] args) {
        Integer arr[] = {78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
        Arrays.stream(arr).sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
