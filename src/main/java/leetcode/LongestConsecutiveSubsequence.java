package leetcode;

/*
 * Problem: Longest Consecutive Sequence (LeetCode 128)
 * Find the length of the longest subsequence of consecutive integers.
 *
 * Input: An array of integers (may contain duplicates)
 * Output: Length of longest consecutive sequence
 *
 * Example:
 *   Input: {0, 1, 1, 1, 1, 1, 2, 3}
 *   Output: 4 (sequence: 0, 1, 2, 3)
 *
 * Memory Trick:
 *   "Sort, skip duplicates, count +1 differences"
 *   - Sort first
 *   - diff == 1 → consecutive, count++
 *   - diff == 0 → duplicate, skip (continue)
 *   - diff > 1 → gap, reset count = 1
 *
 *   Better O(n) approach: Use HashSet, start counting
 *   only from sequence start (no num-1 in set)
 *
 * Time Complexity: O(n log n) - Due to sorting
 * Space Complexity: O(1) - Sorting in-place
 */
import java.util.Arrays;
import java.util.Map;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 2, 3};
        int N = arr.length;
        int count = 1;
        int maxCount = 1;
        if (N == 1) {
            System.out.println("Longest subsequence is 1");
            return;
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                count++;
            } else if (arr[i + 1] - arr[i] == 0) {
                continue;
            } else {
                count = 1;
            }
            maxCount = Math.max(count, maxCount);
        }
        System.out.println("Longest subsequence is " + maxCount);
    }
}
