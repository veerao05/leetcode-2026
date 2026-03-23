package leetcode.arrays;

/*
 * Problem: Stock Span Problem (LeetCode 901)
 * For each day, find the number of consecutive days (including today)
 * where the stock price was less than or equal to today's price.
 *
 * Input: Array of daily stock prices
 * Output: Array of spans for each day
 *
 * Example:
 *   Input:  {10, 4, 5, 90, 120, 80}
 *   Output: { 1, 1, 2,  4,   5,  1}
 *
 *   Explanation:
 *   - Day 0 (10): No previous → span = 1
 *   - Day 1 (4):  4 < 10 → span = 1
 *   - Day 2 (5):  5 > 4, but 5 < 10 → span = 2
 *   - Day 3 (90): 90 > all previous → span = 4
 *   - Day 4 (120): 120 > all → span = 5
 *   - Day 5 (80): 80 < 120 → span = 1
 *
 * Approach (Monotonic Stack):
 *   - Stack stores INDICES of prices in decreasing order
 *   - Pop while current price > stack top price
 *   - Span = distance to nearest greater element (or all days if none)
 *
 * Memory Trick:
 *   "Stack holds indices of GREATER prices to the left"
 *   - Pop smaller prices (they're "shadowed" by current)
 *   - If stack empty: no greater price exists → span = i + 1
 *   - Else: span = i - stack.peek() (distance to greater)
 *
 *   Similar to: Daily Temperatures, Next Greater Element
 *
 * Time Complexity: O(n) - Each element pushed/popped at most once
 * Space Complexity: O(n) - Stack can hold all elements
 */
import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] price = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int[] S = new int[n];
        int[] res = calculateSpan(price, n, S);
        Arrays.stream(res).forEach(System.out::println);


    }

    private static int[] calculateSpan(int[] price, int n, int[] span) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[i] > price[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1; // there is no smaller element than your top.you popped all.
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return span;

    }
}
