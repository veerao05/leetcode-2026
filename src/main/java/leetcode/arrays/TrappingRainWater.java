package leetcode.arrays;

/*
 * Problem: Trapping Rain Water (LeetCode 42)
 * Given n non-negative integers representing elevation map bars,
 * compute how much water can be trapped after raining.
 *
 * Input: Array of bar heights
 * Output: Total units of water trapped
 *
 * Example:
 *   Input: {3, 0, 2, 0, 4}
 *   Output: 7
 *
 *   Visual:
 *         |
 *   |~~~|~|
 *   |~|~|~|
 *   |_|_|_|
 *   3 0 2 0 4
 *
 *   Water at index 1: min(3,4) - 0 = 3
 *   Water at index 2: min(3,4) - 2 = 1
 *   Water at index 3: min(3,4) - 0 = 3
 *   Total = 7
 *
 * Approach (Find Global Max, Scan Both Sides):
 *   1. Find the tallest bar (global max) and its index
 *   2. Scan LEFT to maxIndex: water = leftMax - height[i]
 *   3. Scan RIGHT to maxIndex: water = rightMax - height[i]
 *
 * Memory Trick:
 *   "Water at each bar = min(leftMax, rightMax) - height"
 *   - Find tallest bar first (it's the watershed)
 *   - From left: track running max, add water
 *   - From right: track running max, add water
 *   - Both sides "drain" towards the tallest bar
 *
 *   Alternative (Two Pointers): O(1) space
 *   - left=0, right=n-1
 *   - Process smaller side, move pointer inward
 *
 * Time Complexity: O(n) - Three passes (find max, left scan, right scan)
 * Space Complexity: O(1) - Only uses variables
 */
public class TrappingRainWater {
    public static void main(String[] args) {

        int[] height = {3, 0, 2, 0, 4};
        System.out.println(trapWater(height));

    }

    private static int trapWater(int[] height) {
        int max = 0;
        int maxIndex = 0;
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int leftMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, max) - height[i];
            totalWater = totalWater + water;
        }

        leftMax = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, max) - height[i];
            totalWater = totalWater + water;
        }
        return totalWater;

    }
}
