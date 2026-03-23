package leetcode;

/*
 * Problem: Jump Game II (LeetCode 45)
 * Find the minimum number of jumps to reach the end of array.
 * Each element represents max jump length from that position.
 *
 * Input: An array where each element is max jump length
 * Output: Minimum jumps needed to reach the last index
 *
 * Example:
 *   Input: {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 *   Output: 3
 *
 * Memory Trick:
 *   "Greedy BFS levels" - Each jump = one BFS level
 *   - farthest = max reach from current level
 *   - current = end of current level
 *   - When i reaches current, we MUST jump → jump++, current = farthest
 *
 *   Think: "How far can I go before I MUST make a jump?"
 *
 * Time Complexity: O(n) - Single pass using greedy approach
 * Space Complexity: O(1) - Only uses variables
 */
public class MinJump {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJump(arr));

    }

    private static int minJump(int[] arr) {
        int jump = 0;
        int farthest = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            if (i == current) {
                current = farthest;
                jump++;
            }
        }
        return jump;
    }

}
