package leetcode.strings;

/*
 * Problem: Third Maximum Number (LeetCode 414)
 * Given an integer array, return the third distinct maximum number.
 * If the third maximum does not exist, return the maximum number.
 *
 * Input: An array of integers
 * Output: Third distinct maximum, or maximum if less than 3 distinct values
 *
 * Example:
 *   Input: [3, 2, 1]
 *   Output: 1 (third max)
 *
 *   Input: [1, 2]
 *   Output: 2 (only 2 distinct, return max)
 *
 *   Input: [2, 2, 3, 1]
 *   Output: 1 (distinct: 3, 2, 1 → third is 1)
 *
 * Approach:
 *   - Sort in descending order
 *   - Skip first 2 elements
 *   - Return the third one
 *   - Memory trick: "Sort descending, skip 2, take next"
 *
 * Time Complexity: O(n log n) - Due to sorting
 * Space Complexity: O(n) - Boxing creates Integer objects
 */
import java.util.Arrays;
import java.util.Comparator;

public class ThirdMaximum {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 2, 1};
        findThirdMax(arr1);  // 1

        int[] arr2 = new int[]{1, 2};
        findThirdMax(arr2);  // 2 (no third max, return max)

        int[] arr3 = new int[]{2, 2, 3, 1};
        findThirdMax(arr3);  // 1 (distinct: 3, 2, 1)
    }

    private static void findThirdMax(int[] arr) {
        Arrays.stream(arr)
                .boxed()
                .distinct()  // Remove duplicates
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
