package leetcode.arrays;

/*
 * Problem: Reshape String into Chunks
 * Remove spaces from string and print it in chunks of k characters per line.
 *
 * Input: An integer k (chunk size) and a string with spaces
 * Output: String printed in rows of k characters each (spaces removed)
 *
 * Example:
 *   Input: k = 3, str = "abc de fghij"
 *   Output:
 *     abc
 *     def
 *     ghi
 *   (remaining 'j' is not printed as it doesn't form a complete chunk)
 *
 * Memory Trick:
 *   "Buffer, print when full, clear"
 *   - Skip spaces
 *   - Append to StringBuilder
 *   - When length == k: print and reset (sb.setLength(0))
 *
 *   Pattern: Accumulate → flush when full → repeat
 *
 * Time Complexity: O(n) - Single pass through string
 * Space Complexity: O(k) - StringBuilder holds at most k chars
 */
public class ReShape {
    public static void main(String[] args) {
        reShape(3, "abc de fghij");

    }

    private static void reShape(int k, String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == ' ') continue;
            sb.append(ch);

            if (sb.length() == k) {
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }


    }
}
