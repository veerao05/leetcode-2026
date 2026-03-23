package commonly.asked;

/*
 * Problem: Check if Two Strings are Anagrams (LeetCode 242)
 * Two strings are anagrams if they contain the same characters
 * with the same frequencies, just rearranged.
 *
 * Input: Two strings
 * Output: True if anagrams, false otherwise
 *
 * Example:
 *   Input: str1 = "own", str2 = "now"
 *   Output: true
 *
 * Memory Trick:
 *   Two approaches:
 *   1. "Sort and compare" (current): O(n log n)
 *      - Sort both → compare
 *   2. "Count and cancel": O(n)
 *      - Count chars in str1 (+1)
 *      - Subtract chars in str2 (-1)
 *      - All counts should be 0
 *
 * Time Complexity: O(n log n) - Due to sorting both strings
 * Space Complexity: O(n) - Character arrays for both strings
 */
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "own";
        String str2 = "now";
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        System.out.println("Arrays equals??" + Arrays.equals(char1, char2));
    }
}
