package leetcode.strings;

/*
 * Problem: Maximum Repeating Substring (LeetCode 1668)
 * Find the maximum k such that word repeated k times is a substring of sequence.
 * The repetitions must be CONSECUTIVE (no gaps between them).
 *
 * Input:
 *   - sequence: The main string to search in
 *   - word: The word to find consecutive repetitions of
 *
 * Output: Maximum k where word repeated k times is a substring
 *
 * Example:
 *   Input: sequence = "ababc", word = "ab"
 *   Output: 2 ("abab" is substring, but "ababab" is not)
 *
 *   Input: sequence = "abctyuabc", word = "abc"
 *   Output: 1 ("abc" exists, but "abcabc" doesn't - separated by "tyu")
 *
 * Approach:
 *   - Start with word, keep appending word
 *   - Count how many times we can append before it's no longer a substring
 *   - Memory trick: "Keep doubling until it doesn't fit"
 *
 * Time Complexity: O(n * m * k) - where n = sequence length, m = word length, k = result
 *                  contains() is O(n*m), called k times
 * Space Complexity: O(m * k) - StringBuilder grows to word repeated k times
 */
public class MaximumRepeatingStrings {
    public static void main(String[] args) {
        System.out.println(maxRepeating("abctyuabc", "abc"));   // 1
        System.out.println(maxRepeating("ababc", "ab"));         // 2
        System.out.println(maxRepeating("abcabcabc", "abc"));    // 3
    }

    private static int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);

        // Keep appending word until it's no longer a substring
        while (sequence.contains(sb.toString())) {
            count++;
            sb.append(word);
        }
        return count;
    }
}
