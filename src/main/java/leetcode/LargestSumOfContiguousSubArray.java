package leetcode;

/*
 * Problem: Maximum Subarray (LeetCode 53) - Kadane's Algorithm
 * Find the contiguous subarray with the maximum sum.
 *
 * Input: An array of integers (can have negative numbers)
 * Output: Maximum sum of any contiguous subarray
 *
 * Example:
 *   Input: {-2, -3, 4, -1, -2, 1, 5, -3}
 *   Output: 7 (subarray {4, -1, -2, 1, 5})
 *
 * Memory Trick:
 *   "KADANE = Keep Adding, Drop if Negative, Always track max"
 *   - curSum += arr[i]         → Keep adding
 *   - if curSum < 0: curSum = 0 → Drop negative sum (start fresh)
 *   - maxSum = max(maxSum, curSum) → Always track best
 *
 *   Think: "Negative sum is a burden, drop it and restart"
 *
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(1) - Only uses variables for tracking sums
 */
public class LargestSumOfContiguousSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        System.out.println("maxSum:::" + maxSum);
    }
}
