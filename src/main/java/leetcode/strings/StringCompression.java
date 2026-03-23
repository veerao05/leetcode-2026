package leetcode.strings;

/*
 * Problem: String Compression (LeetCode 443)
 * Compress a character array using run-length encoding.
 * Replace consecutive repeating characters with the character followed by count.
 * If count is 1, don't append the count.
 *
 * Input: A character array with consecutive repeating characters
 * Output: Compressed string (char + count for runs > 1)
 *
 * Example:
 *   Input: ['a','a','b','b','c','c','b','b','b','b','b','b','b','c','c','d','e']
 *   Output: "a2b2c2b7c2de"
 *   Explanation:
 *     - "aa" → "a2"
 *     - "bb" → "b2"
 *     - "cc" → "c2"
 *     - "bbbbbbb" → "b7"
 *     - "cc" → "c2"
 *     - "d" → "d" (count=1, no number)
 *     - "e" → "e" (count=1, no number)
 *
 * Approach:
 *   - Iterate through array, count consecutive same characters
 *   - Append character, then count (only if > 1)
 *   - Move index forward while counting
 *
 * Memory Trick:
 *   "WRITE first, COUNT while matching, SKIP counted"
 *
 *   Pattern to remember:
 *   1. WRITE the character immediately (sb.append(word[i]))
 *   2. COUNT how many same chars follow (while loop)
 *   3. APPEND count only if > 1 (lonely chars don't need numbers)
 *   4. The 'i++' inside while loop SKIPS already counted chars
 *
 *   Think: "Attendance roll call"
 *   - Call the name (write char)
 *   - Count how many with same name (while loop)
 *   - Write total if more than 1 present
 *
 *   Key insight: You're moving 'i' INSIDE the while loop,
 *   so outer for-loop picks up where counting stopped!
 *
 * Time Complexity: O(n) - Single pass through the array
 * Space Complexity: O(n) - StringBuilder to store result
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressString(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'd', 'e'}));
        System.out.println("----");
    }

    private static String compressString(char[] word) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length; i++) {
            sb.append(word[i]);
            int count = 1;

            while (i < word.length - 1) {
                if (word[i] == word[i + 1]) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }

            if (count > 1) {
                sb.append(count);
            }

        }
        return sb.toString();
    }
}
