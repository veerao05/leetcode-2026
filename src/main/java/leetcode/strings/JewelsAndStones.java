package leetcode.strings;

/*
 * Problem: Jewels and Stones (LeetCode 771)
 * Count how many of your stones are also jewels.
 * Letters are case-sensitive ('a' and 'A' are different).
 *
 * Input:
 *   - jewels: String representing types of stones that are jewels
 *   - stones: String representing stones you have
 *
 * Output: Number of stones that are jewels
 *
 * Example:
 *   Input: jewels = "aA", stones = "aAAbbbb"
 *   Output: 3 (stones 'a', 'A', 'A' are jewels)
 *
 * Approach: Use HashSet for O(1) lookup of jewel types
 * Memory trick: "Put jewels in a Set, then count matching stones"
 *
 * Time Complexity: O(j + s) - where j = jewels length, s = stones length
 * Space Complexity: O(j) - HashSet stores jewel types
 */
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println("Jewels in Stones:: " + numJewelsInStones("aA", "aAAbbbb"));  // 3
    }

    private static int numJewelsInStones(String jewels, String stones) {
        // Step 1: Add all jewel types to a Set
        Set<Character> jewelSet = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            jewelSet.add(ch);
        }

        // Step 2: Count stones that are jewels
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewelSet.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}