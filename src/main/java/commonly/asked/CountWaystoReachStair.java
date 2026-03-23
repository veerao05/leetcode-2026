package commonly.asked;

/*
 * Problem: Climbing Stairs (LeetCode 70)
 * Count distinct ways to reach the nth stair, taking 1 or 2 steps at a time.
 * This is essentially the Fibonacci sequence.
 *
 * Input: Number of stairs n
 * Output: Number of distinct ways to climb
 *
 * Example:
 *   Input: n = 4
 *   Output: 5 (ways: 1111, 112, 121, 211, 22)
 *
 * Memory Trick:
 *   "Stairs = Fibonacci!"
 *   - To reach step n, you came from n-1 or n-2
 *   - ways(n) = ways(n-1) + ways(n-2)
 *   - Base: ways(1) = 1, ways(2) = 2
 *
 *   Space-optimized: Only track prev two values
 *   cur = prev1 + prev2, then shift
 *
 * Time Complexity: O(n) - Single loop
 * Space Complexity: O(1) - Only two variables
 */
public class CountWaystoReachStair {
    public static void main(String[] args) {
        int prev1 = 1;
        int prev2 = 1;
        int n = 4;
        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        System.out.println("Number of Ways : " + prev1);
    }
}
