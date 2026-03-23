package leetcode.strings;

/*
 * Problem: Maximum Number of Words Found in Sentences (LeetCode 2114)
 * Given an array of sentences, find the maximum number of words in any sentence.
 * A word is defined as a substring separated by single spaces.
 *
 * Input: Array of sentences (strings)
 * Output: Maximum word count among all sentences
 *
 * Example:
 *   Input: ["alice and bob love leetcode",   // 5 words
 *           "i think so too",                 // 4 words
 *           "this is great thanks very much"] // 6 words
 *   Output: 6
 *
 * Approach:
 *   - Split each sentence by space
 *   - Count words (array length after split)
 *   - Return maximum count
 *   - Memory trick: "Split by space, count the pieces, find max"
 *
 * Time Complexity: O(n * m) - n sentences, m average chars per sentence
 * Space Complexity: O(w) - split creates array of w words for each sentence
 */
import java.util.Arrays;

public class MaximumWordsInSentence {
    public static void main(String[] args) {
        String[] sentences = new String[]{
                "alice and bob love leetcode",      // 5 words
                "i think so too",                    // 4 words
                "this is great thanks very much"     // 6 words
        };

        // Stream approach: split each sentence, count words, find max
        Arrays.stream(sentences)
                .mapToInt(s -> s.split(" ").length)
                .max()
                .ifPresent(System.out::println);  // Output: 6
    }
}
