package leetcode.strings;

/*
 * Problem: Find the Index of the First Occurrence in a String (LeetCode 28)
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Input: Two strings - haystack (main string) and needle (substring to find)
 * Output: Index of first occurrence, or -1 if not found
 *
 * Example:
 *   Input: str = "leetcode", subStr = "code"
 *   Output: 4
 *
 *   Input: str = "leetcode", subStr = "leeto"
 *   Output: -1
 *
 * Memory Trick:
 *   "Sliding window of needle length"
 *   - Loop from 0 to (n - m) inclusive
 *   - Extract substring of length m, compare
 *   - Return first match index
 *
 *   Key: Loop boundary is <= (n - m), not < n
 *   Alternative: str.indexOf(subStr) built-in method
 *
 * Time Complexity: O((n-m) * m) - n = str length, m = subStr length
 * Space Complexity: O(m) - substring creates new string
 */
public class IndexFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(indexFirstOccurrence("leetcode", "leeto"));  // -1
        System.out.println(indexFirstOccurrence("leetcode", "code"));   // 4
        System.out.println(indexFirstOccurrence("hello", "lo"));        // 3
    }

    private static int indexFirstOccurrence(String str, String subStr) {
        int subStrLength = subStr.length();
        int strLength = str.length();

        // Edge case: if both strings are equal
        if (strLength == subStrLength && str.equals(subStr)) return 0;

        // Check each possible starting position
        for (int i = 0; i <= strLength - subStrLength; i++) {
            if (str.substring(i, i + subStrLength).equals(subStr)) {
                return i;
            }
        }
        return -1;
    }
}
