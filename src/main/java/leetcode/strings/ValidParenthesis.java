package leetcode.strings;

/*
 * Problem: Valid Parentheses (LeetCode 20)
 * Given a string with brackets, determine if brackets are valid.
 * Valid means: every opening bracket has matching closing bracket in correct order.
 *
 * Input: String containing '(', ')', '{', '}', '[', ']'
 * Output: true if valid, false otherwise
 *
 * Example:
 *   Input: "()"      → true
 *   Input: "()[]{}"  → true
 *   Input: "(]"      → false
 *   Input: "({[)}]"  → false (wrong order)
 *
 * Approach (Stack):
 *   - Push opening brackets onto stack
 *   - For closing brackets, pop and check if matches
 *   - At end, stack must be empty
 *
 * Memory Trick:
 *   "LIFO matching" - Last opened must be first closed
 *   - Opening bracket → PUSH
 *   - Closing bracket → POP and compare
 *   - Empty stack at end → VALID
 *
 * Time Complexity: O(n) - Single pass through string
 * Space Complexity: O(n) - Stack can hold n/2 brackets worst case
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValidParenthesis("({[)}]"));

    }

    private static boolean isValidParenthesis(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;

                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != map.get(ch)) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
