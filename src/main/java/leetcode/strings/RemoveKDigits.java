package leetcode.strings;

/*
 * Problem: Remove K Digits (LeetCode 402)
 * Given a non-negative integer represented as a string, remove k digits
 * to make the resulting number as small as possible.
 *
 * Input: A string of digits and an integer k
 * Output: The smallest possible number after removing k digits (as string)
 *
 * Example:
 *   Input: num = "1432219", k = 3
 *   Output: "1219"
 *   Explanation: Remove 4, 3, and 2 to get "1219"
 *
 *   Input: num = "10200", k = 1
 *   Output: "200"
 *   Explanation: Remove leading 1, result is "0200" → "200"
 *
 *   Input: num = "10", k = 2
 *   Output: "0"
 *   Explanation: Remove all digits, return "0"
 *
 * Approach (Monotonic Stack):
 *   - Use a stack to build the smallest number
 *   - For each digit, pop larger digits from stack (if k > 0)
 *   - This ensures leftmost digits are as small as possible
 *   - Handle remaining k by removing from end
 *   - Strip leading zeros from result
 *
 * Memory Trick:
 *   "LEFT is MOST important" - Leftmost digits have the most impact
 *   on the number's value. So whenever you see a LARGER digit followed
 *   by a SMALLER digit, remove the larger one (like removing a "peak").
 *   Think: "Remove peaks, keep valleys" - monotonically increasing stack!
 *
 * Time Complexity: O(n) - Each digit pushed/popped at most once
 * Space Complexity: O(n) - Stack stores at most n digits
 */
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));  // 1219
    }

    private static String removeKdigits(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }

        String finalResult = result.substring(index);
        return finalResult.length() == 0 ? "0" : finalResult;

    }
}
