package leetcode;

/*
 * Problem: Missing Number (LeetCode 268)
 * Given an array containing n distinct numbers from 0 to n, find the missing one.
 *
 * Input: An array of n integers from 0 to n with one missing
 * Output: The missing number
 *
 * Example:
 *   Input: {9, 6, 4, 2, 3, 5, 7, 0, 1}
 *   Output: 8 (missing from 0-9)
 *
 * Memory Trick:
 *   "Expected - Actual = Missing"
 *   - Expected sum of 0 to n = n*(n+1)/2
 *   - Actual sum = sum of array elements
 *   - Missing = Expected - Actual
 *
 *   Alternative: XOR approach
 *   - XOR all indices 0 to n
 *   - XOR all array elements
 *   - Result = missing number (duplicates cancel out)
 *
 * Time Complexity: O(n) - Single pass to calculate sum
 * Space Complexity: O(1) - Only uses variables
 */
public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(MissingNo(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));

    }

    private static int MissingNo(int[] arr) {
        int actualSum = 0;
        int expectedSum = (arr.length * (arr.length + 1)) / 2;
        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        return expectedSum - actualSum;
    }
}
