package leetcode.strings;

/*
 * Problem: Goal Parser Interpretation (LeetCode 1678)
 * Parse a string where:
 *   - "G" → "G"
 *   - "()" → "o"
 *   - "(al)" → "al"
 *
 * Input: A string containing "G", "()", and "(al)"
 * Output: Interpreted string
 *
 * Example:
 *   Input: "G()(al)"
 *   Output: "Goal"
 *
 *   Input: "G()()()()(al)"
 *   Output: "Gooooal"
 *
 * Approach:
 *   - Iterate through string
 *   - If not '(' or ')', append char directly
 *   - If ')' preceded by '(', append "o"
 *   - "(al)" handled by appending 'a' and 'l' directly
 *
 * Memory Trick:
 *   "Skip parentheses, detect empty ()"
 *   - Regular chars (G, a, l) → append as-is
 *   - "()" pattern → append "o"
 *   - Parentheses themselves → skip
 *
 * Time Complexity: O(n) - Single pass through string
 * Space Complexity: O(n) - StringBuilder for result
 */
public class GoalInterpretation {
    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }

    private static String interpret(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= str.length()-1; i++) {
            if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                stringBuilder.append(str.charAt(i));
            } else if (str.charAt(i) == ')' && str.charAt(i - 1) == '(') {
                stringBuilder.append("O");
            }
        }
        return stringBuilder.toString();
    }
}
