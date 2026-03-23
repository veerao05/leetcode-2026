package leetcode;

/*
 * Problem: 3Sum (LeetCode 15)
 * Find all triplets in array that add up to the given sum.
 *
 * Input: An array of integers and a target sum
 * Output: All triplets (a, b, c) where a + b + c = sum
 *
 * Example:
 *   Input: arr = {1, 4, 45, 6, 10, 8}, sum = 22
 *   Output: (4, 10, 8), (1, 6, 15) etc.
 *
 * Memory Trick:
 *   "3Sum = Fix one + 2Sum"
 *   - Fix arr[i], then find pair that sums to (target - arr[i])
 *   - Use HashSet for O(1) lookup of complement
 *   - curr_sum = sum - arr[i] → now find 2Sum = curr_sum
 *
 *   Alternative: Sort + Two Pointers (avoids duplicates easier)
 *
 * Time Complexity: O(n^2) - Outer loop + HashSet lookup
 * Space Complexity: O(n) - HashSet for each iteration
 */
import java.util.HashSet;
import java.util.Set;

public class TripletOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int n = arr.length;
        int sum = 22;
        find3Numbers(arr, n, sum);

    }

    private static void find3Numbers(int[] arr, int n, int sum) {

        for (int i = 0; i < n - 2; i++) {
            int curr_sum = sum - arr[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                if (set.contains(curr_sum - arr[j])) {
                    System.out.println("Found pairs::" + arr[i] + " " + arr[j] + " " + (curr_sum - arr[j]));
                }
                set.add(arr[j]);
            }
        }
    }
}
