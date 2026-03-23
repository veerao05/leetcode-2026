package leetcode.arrays.dp;

/*
 * Problem: Coin Change - Minimum Coins (LeetCode 322)
 * Given coins of different denominations and a total amount,
 * find the minimum number of coins needed to make up that amount.
 * Return -1 if it's not possible.
 *
 * Input: Array of coin denominations and target amount
 * Output: Minimum number of coins needed
 *
 * Example:
 *   Input: coins = [1, 2, 3], amount = 5
 *   Output: 2
 *   Explanation: 5 = 2 + 3 (2 coins)
 *
 *   Input: coins = [2], amount = 3
 *   Output: -1 (impossible)
 *
 * Approach (2D DP - Unbounded Knapsack):
 *   - dp[i][j] = min coins using first i coins to make amount j
 *   - If coin > amount: can't use it, take previous row
 *   - Else: min(don't use coin, 1 + use coin again)
 *
 * Memory Trick:
 *   "UNBOUNDED Knapsack" - Can use same coin multiple times!
 *   - Key: temp[i][j - currentCoin] (same row i, not i-1)
 *   - Think: "Stay in same row = can reuse coin"
 *
 *   DP Table visualization for coins=[1,2,3], amount=5:
 *        0  1  2  3  4  5
 *   []   0  ∞  ∞  ∞  ∞  ∞
 *   [1]  0  1  2  3  4  5
 *   [1,2] 0  1  1  2  2  3
 *   [1,2,3] 0 1  1  1  2  2  ← Answer: 2
 *
 * Time Complexity: O(n * amount) - Fill n×amount table
 * Space Complexity: O(n * amount) - 2D DP table
 */
public class MinimumNoOfCoins {
    public static void main(String[] args) {
        int total = 5;
        int[] coins = {1, 2, 3};
        System.out.println(minimumNoOfCoins(coins, total));

    }

    private static int minimumNoOfCoins(int[] coins, int total) {
        int[][] temp = new int[coins.length + 1][total + 1];
        for (int j = 0; j <= total; j++) {
            temp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                int currentCoin = coins[i - 1];
                if (currentCoin > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = Math.min((1 + temp[i][j - currentCoin]), temp[i - 1][j]);
                }
            }
        }
        return temp[coins.length][total];
    }
}
