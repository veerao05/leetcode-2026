package leetcode.arrays.dp;

/*
 * Problem: Coin Change 2 - Count Ways (LeetCode 518)
 * Given coins of different denominations and a total amount,
 * find the NUMBER OF WAYS to make up that amount.
 *
 * Input: Array of coin denominations and target amount
 * Output: Number of different combinations to make the amount
 *
 * Example:
 *   Input: coins = [1, 2, 3], amount = 5
 *   Output: 5
 *   Explanation: 5 ways:
 *     5 = 1+1+1+1+1
 *     5 = 1+1+1+2
 *     5 = 1+2+2
 *     5 = 1+1+3
 *     5 = 2+3
 *
 * Approach (2D DP - Unbounded Knapsack):
 *   - dp[i][j] = number of ways using first i coins to make amount j
 *   - Base case: dp[i][0] = 1 (one way to make 0: use nothing)
 *   - If coin > amount: can't use it, take previous row
 *   - Else: ADD (use coin again) + (don't use coin)
 *
 * Memory Trick:
 *   "COUNT ways = ADD choices" (not min/max)
 *   - temp[i][j - currentCoin] + temp[i - 1][j]
 *   - Same row (i) = can reuse coin (unbounded)
 *   - Think: "Ways WITH this coin + Ways WITHOUT this coin"
 *
 * Time Complexity: O(n * amount) - Fill n×amount table
 * Space Complexity: O(n * amount) - 2D DP table
 */
public class NoOfCoins {
    public static void main(String[] args) {
        int total = 5;
        int[] coins = {1, 2, 3};
        System.out.println(noOfCoins(coins, total));

    }

    private static int noOfCoins(int[] coins, int total) {
        int[][] temp = new int[coins.length + 1][total + 1];
        for (int i = 0; i <= coins.length; i++) {
            temp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                int currentCoin = coins[i - 1];
                if (currentCoin > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i][j - currentCoin] + temp[i - 1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
}
