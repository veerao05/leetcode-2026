package leetcode.arrays.dp;

/*
 * Problem: Partition Equal Subset Sum (LeetCode 416)
 * Given an array, determine if it can be partitioned into two subsets
 * with equal sum.
 *
 * Input: Array of positive integers
 * Output: true if can partition into two equal sum subsets, false otherwise
 *
 * Example:
 *   Input: [1, 3, 2]
 *   Output: true
 *   Explanation: [1,2] and [3] both sum to 3
 *
 *   Input: [1, 2, 4]
 *   Output: false
 *   Explanation: Total=7 (odd), impossible to split equally
 *
 * Approach (Subset Sum DP):
 *   1. If total sum is ODD → return false immediately
 *   2. Find if subset exists with sum = total/2
 *   - dp[i][j] = can we make sum j using first i items?
 *   - Include or Exclude each item
 *
 * Memory Trick:
 *   "Partition = Subset Sum with target = total/2"
 *   - First check: ODD total → impossible (quick exit)
 *   - Then: standard 0/1 Knapsack (each item used ONCE)
 *   - i-1 row (not i) = item used only once
 *
 * Time Complexity: O(n * sum) - Fill n×(sum/2) table
 * Space Complexity: O(n * sum) - 2D boolean table
 */
import java.util.Arrays;

public class SubsetSumPartition {

    public static boolean subsetSum(int[] nums, int target) {

        int n = nums.length;

        // T[i][j] = can we make sum j using first i items?
        boolean[][] T = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always achievable (pick nothing)
        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {

                int item = nums[i - 1]; // current item at row i

                if (item > j) {
                    // item too big to fit in sum j
                    // go to row above = world without this item
                    // just copy that answer, we cannot use this item
                    T[i][j] = T[i - 1][j];

                } else {
                    // item fits! two choices:

                    // Choice 1 — EXCLUDE this item
                    // go to row above = world without this item
                    // same sum j, can we make it without this item?
                    boolean exclude = T[i - 1][j];

                    // Choice 2 — INCLUDE this item once right now
                    // use this item (subtract it from sum)
                    // then go to row above = world before this item existed
                    // ask: can previous items make the remaining sum?
                    boolean include = T[i - 1][j - item];

                    // if either works → TRUE
                    T[i][j] = exclude || include;
                }
            }
        }

        return T[n][target];
    }

    public static boolean partition(int[] nums) {

        int total = Arrays.stream(nums).sum();

        // odd total → can never split equally
        if ((total & 1) != 0) {
            return false;
        }

        return subsetSum(nums, total / 2);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 2};
        // total=6, target=3
        // Group1={1,2}=3, Group2={3}=3
        System.out.println("{1,3,2}     → " + partition(nums1)); // true

        int[] nums2 = {3, 3};
        // total=6, target=3
        // Group1={3}, Group2={3}
        System.out.println("{3,3}       → " + partition(nums2)); // true

        int[] nums3 = {7, 3, 1, 5, 4, 8};
        // total=28, target=14
        // Group1={7,3,4}=14, Group2={1,5,8}=14
        System.out.println("{7,3,1,5,4,8} → " + partition(nums3)); // true

        int[] nums4 = {1, 2, 4};
        // total=7 → odd → false immediately
        System.out.println("{1,2,4}     → " + partition(nums4)); // false
    }
}
