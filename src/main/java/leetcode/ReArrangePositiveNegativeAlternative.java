package leetcode;

/*
 * Problem: Rearrange Array by Sign (LeetCode 2149)
 * Rearrange array so positive and negative numbers alternate.
 * Positives at even indices, negatives at odd indices.
 *
 * Input: An array with equal positive and negative numbers
 * Output: Array with alternating positive and negative values
 *
 * Example:
 *   Input: {-5, 3, 4, 6, -6, -2, 8, 9, -1, -4}
 *   Output: {3, -5, 4, -6, 6, -2, 8, -1, 9, -4}
 *
 * Memory Trick:
 *   "Split, then interleave by index"
 *   1. Separate positives and negatives into two lists
 *   2. Even index (0,2,4...) → take from positives
 *   3. Odd index (1,3,5...) → take from negatives
 *
 *   i % 2 == 0 → positive turn
 *   i % 2 == 1 → negative turn
 *
 * Time Complexity: O(n) - Two passes through array
 * Space Complexity: O(n) - Two lists for pos/neg
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrangePositiveNegativeAlternative {
    public static void main(String[] args) {
        int[] nums = rearrangeArray(new int[]{-5, 3, 4, 6, -6, -2, 8, 9, -1, -4});
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    private static int[] rearrangeArray(int[] arr) {
        List<Integer> listP = new ArrayList<>();
        List<Integer> listN = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                listP.add(num);
            } else {
                listN.add(num);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = listP.get(i / 2);
            } else {
                arr[i] = listN.get(i / 2);
            }
        }
        return arr;
    }
}
