package leetcode;

/*
 * Problem: Find Peak Element (LeetCode 162)
 * A peak element is an element that is strictly greater than its neighbors.
 * For corner elements, only one neighbor is considered.
 *
 * Input: An array of integers
 * Output: Index of any peak element
 *
 * Example:
 *   Input: {1, 3, 20, 4, 1, 0}
 *   Output: 2 (element 20 is a peak)
 *
 * Memory Trick:
 *   "Mountain peak" - Higher than both neighbors
 *   - Check corners first (only 1 neighbor)
 *   - Then scan middle elements
 *   - Can optimize to O(log n) with Binary Search!
 *
 * Time Complexity: O(n) - Linear scan through array
 * Space Complexity: O(1) - No extra space used
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int n = arr.length;
        System.out.print("Index of a peak point is " + findPeak(arr, n));
    }

    private static int findPeak(int[] arr, int n) {
        if (n == 1) return 0;
        if (arr[0] >= arr[1]) return 0;
        if (arr[n - 1] >= arr[n - 2]) return n - 1;

        for (int i = 1; i <= n - 2; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
