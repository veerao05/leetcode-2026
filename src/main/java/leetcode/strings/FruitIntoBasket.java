package leetcode.strings;

/*
 * Problem: Fruit Into Baskets (LeetCode 904)
 * You have 2 baskets, each can hold only ONE type of fruit.
 * Find the maximum number of fruits you can collect in a contiguous subarray
 * with at most 2 different types.
 *
 * Input: An array where each element represents a fruit type
 * Output: Maximum number of fruits (length of longest subarray with ≤2 types)
 *
 * Example:
 *   Input: [0, 1, 2, 2]
 *   Output: 3
 *   Explanation: Pick [1, 2, 2] → 3 fruits (types 1 and 2)
 *
 *   Input: [1, 2, 1]
 *   Output: 3
 *   Explanation: Pick all [1, 2, 1] → 3 fruits (types 1 and 2)
 *
 *   Input: [3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4]
 *   Output: 5
 *   Explanation: [1, 2, 1, 1, 2] → 5 fruits
 *
 * Approach (Sliding Window):
 *   - Use HashMap to track fruit types and their counts in current window
 *   - Expand window by adding fruits from right (end++)
 *   - When more than 2 types, shrink from LEFT (start++) until ≤2 types
 *   - Track maximum window size
 *
 * Memory Trick:
 *   "2 BASKETS = At most 2 KEYS in HashMap"
 *   - Expand right, shrink LEFT when > 2 types
 *   - KEY BUG TO AVOID: When shrinking, remove fruits[START], not fruits[END]!
 *   - Think: "Sliding window with map.size() ≤ 2"
 *
 * Time Complexity: O(n) - Each element visited at most twice (add + remove)
 * Space Complexity: O(1) - Map holds at most 3 entries
 */
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2};
        System.out.println(totalFruit(arr));


    }

    private static int totalFruit(int[] fruits) {
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (end < fruits.length) {
            int fruit = fruits[end];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            while (basket.size() > 2) {
                int leftFruit = fruits[start];  // Remove from LEFT side, not current!
                if (basket.get(leftFruit) == 1) {
                    basket.remove(leftFruit);
                } else {
                    basket.put(leftFruit, basket.get(leftFruit) - 1);
                }
                start++;  // Always move start when shrinking window
            }

            max = Math.max(max, (end - start) + 1);
            end++;


        }
        return max;
    }
}
