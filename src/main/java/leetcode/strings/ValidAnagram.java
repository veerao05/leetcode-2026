package leetcode.strings;

/*
 * Problem: Valid Anagram (LeetCode 242)
 * Given two strings, determine if they are anagrams of each other.
 * Anagram = same characters, different arrangement.
 *
 * Input: Two strings
 * Output: true if anagrams, false otherwise
 *
 * Example:
 *   Input: s = "anagram", t = "nagaram"
 *   Output: true
 *
 *   Input: s = "rat", t = "car"
 *   Output: false
 *
 * Approach (HashMap counting):
 *   - Count chars in first string (+1)
 *   - Subtract chars in second string (-1)
 *   - All counts should be 0 if anagram
 *
 * Memory Trick:
 *   "ADD then SUBTRACT" - If anagram, counts cancel out
 *   - First string: increment counts
 *   - Second string: decrement counts
 *   - Check all values are 0 (or map values sum to 0)
 *
 * Note: Current code has bug - should check if all values are 0,
 *       not if map is empty. Map won't be empty after operations.
 *
 * Time Complexity: O(n) - Two passes through strings
 * Space Complexity: O(1) - At most 26 letters (constant)
 */
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    private static boolean isAnagram(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        return map.isEmpty();
    }
}
