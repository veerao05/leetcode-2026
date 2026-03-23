package leetcode.arrays;

/*
 * Problem: Move Zeroes (LeetCode 283)
 * Move all zeros to the end of array while maintaining relative order of non-zero elements.
 *
 * Input: An array of integers containing zeros and non-zeros
 * Output: Array with all zeros moved to the end, non-zero order preserved
 *
 * Example:
 *   Input: {0, 1, 0, 3, 12}
 *   Output: {1, 3, 12, 0, 0}
 *
 * Memory Trick:
 *   "Snowplow" - Push non-zeros to front, fill rest with zeros
 *   - index = position for next non-zero
 *   - When you see non-zero: place it at index, index++
 *   - After loop: fill remaining positions with 0
 *
 *   Think: "Compact non-zeros first, then pad zeros"
 *
 * Time Complexity: O(n) - Single pass to move non-zeros + fill zeros
 * Space Complexity: O(1) - In-place modification
 */
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroesV2(new int[]{0, 1, 0, 3, 12});
    }

    private static void moveZeroesV2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
