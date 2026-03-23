package leetcode.strings;

/*
 * Problem: Longest Substring with At Most K Distinct Characters (LeetCode 340)
 * Find the length of the longest substring with at most K distinct characters.
 *
 * Input: A string and integer K
 * Output: Length of longest substring with ≤K distinct characters
 *
 * Example:
 *   Input: s = "aabacbebebe", k = 3
 *   Output: 7
 *   Explanation: "cbebebe" has 3 distinct chars (c, b, e)
 *
 *   Input: s = "eceba", k = 2
 *   Output: 3
 *   Explanation: "ece" has 2 distinct chars
 *
 * Approach (Sliding Window):
 *   - Use HashMap to track character counts in window
 *   - Expand window (j++) and add chars
 *   - When map.size() > k, shrink from left (i++)
 *   - Track max window size when map.size() == k
 *
 * Memory Trick:
 *   "K KEYS in Map = K distinct chars"
 *   - Expand right (j++), shrink left (i++) when > K keys
 *   - Same pattern as "Fruit Into Baskets" (where K=2)
 *   - Remove char from map when count becomes 0
 *
 * Time Complexity: O(n) - Each char visited at most twice
 * Space Complexity: O(k) - Map holds at most k+1 entries
 */
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        System.out.println(longestSubString(s, 3));

    }

    private static int longestSubString(String s, int k) {
        int i = 0, j = 0;
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            if (map.size() == k) {
                max = Math.max(max, (j - i) + 1);
            }
            j++;
        }
        return max;
    }
}
