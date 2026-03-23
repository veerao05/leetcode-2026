package leetcode;

/*
 * Problem: Minimize the Maximum Difference Between Tower Heights
 * Given tower heights, increase or decrease each by k to minimize
 * the difference between the tallest and shortest tower.
 *
 * Input: Array of tower heights and integer k
 * Output: Minimum possible difference between max and min heights
 *
 * Example:
 *   Input: arr = {1, 15, 10}, k = 6
 *   Output: 5 (heights become {7, 9, 4} → diff = 9-4 = 5)
 *
 * Memory Trick:
 *   "Sort, then try all split points"
 *   - After sorting, small towers +k, large towers -k
 *   - Find the split point that minimizes max-min
 *   - For each split i:
 *     - max = max(arr[i-1]+k, arr[n-1]-k)
 *     - min = min(arr[0]+k, arr[i]-k)
 *   - Skip if arr[i]-k < 0 (can't have negative heights)
 *
 * Time Complexity: O(n log n) - Due to sorting
 * Space Complexity: O(1) - Only uses variables
 */
import java.util.Arrays;

public class MinimiseTowerHeights {
    public static void main(String[] args) {
        int[] arr = {1, 15, 10};
        int k = 6;
        System.out.println("Minimum height::" + minDiffOfTower(arr, k));

    }

    private static int minDiffOfTower(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 1;
        Arrays.sort(arr);
        int diff = arr[n - 1] - arr[0];
        int max;
        int min;
        for (int i = 1; i < n; i++) {
            if(arr[i] - k<0)continue;
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            min = Math.min(arr[0] + k, arr[i] - k);
            diff = Math.min(diff, (max - min));
        }
        return diff;
    }
}
