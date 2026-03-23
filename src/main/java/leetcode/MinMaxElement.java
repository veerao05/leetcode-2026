package leetcode;

/*
 * Problem: Find Minimum and Maximum Element in Array
 * Find the smallest and largest elements in an unsorted array.
 *
 * Input: An array of integers
 * Output: Minimum and maximum values
 *
 * Example:
 *   Input: {12, 1234, 45, 67, 1}
 *   Output: Min = 1, Max = 1234
 *
 * Memory Trick:
 *   "Arrays.stream(arr).min() / .max()"
 *   - Returns OptionalInt, use getAsInt()
 *   - Can also use single pass: track both min and max together
 *   - Tournament method: O(3n/2) comparisons
 *
 * Time Complexity: O(n) - Stream traverses array once
 * Space Complexity: O(1) - No extra space used
 */
import java.util.Arrays;

public class MinMaxElement {
    public static void main(String[] args) {
        int arr[] = {12, 1234, 45, 67, 1};
        int n = arr.length;
        System.out.println("Minimum element of array: " + Arrays.stream(arr).min().getAsInt());
        System.out.println("Maximum element of array: " + Arrays.stream(arr).max().getAsInt());

    }
}
