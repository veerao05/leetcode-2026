package leetcode;

/*
 * Problem: Subarray Sum Equals Zero
 * Check if there exists a contiguous subarray with sum equal to zero.
 *
 * Input: An array of integers
 * Output: True if zero-sum subarray exists, false otherwise
 *
 * Example:
 *   Input: {4, 2, -3, 1, 6} → True (subarray {2, -3, 1} sums to 0)
 *   Input: {-3, 2, 3, 1, 6} → False (no zero-sum subarray)
 *
 * Memory Trick:
 *   "Prefix sum repeat = Zero sum subarray!"
 *   - If prefix[i] == prefix[j], then sum(i+1 to j) = 0
 *   - Store prefix sums in HashSet
 *   - Three cases for true:
 *     1. arr[i] == 0 (single element is 0)
 *     2. sum == 0 (prefix from start is 0)
 *     3. sum seen before (prefix repeats)
 *
 * Time Complexity: O(n) - Single pass using prefix sum
 * Space Complexity: O(n) - HashSet stores prefix sums
 */
import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int arr[] = {-3, 2, 3, 1, 6};
        if (subArrayZero(arr)) {
            System.out.println("subArray contains 0");
        }
        else {
            System.out.println("subArray doesn't contains 0");
        }

    }

    private static boolean subArrayZero(int[] arr) {
        Set<Integer> set = new HashSet<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}
