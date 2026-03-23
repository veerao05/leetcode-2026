package leetcode;

/*
 * Problem: Count Pairs with Given Sum (Two Sum variant)
 * Count the number of pairs in array whose sum equals the target.
 *
 * Input: An array of integers and a target sum
 * Output: Number of pairs that add up to the target
 *
 * Example:
 *   Input: arr = {1, 5, 7, -1, 5}, target = 6
 *   Output: 3 (pairs: (1,5), (1,5), (7,-1))
 *
 * Memory Trick:
 *   "Look for complement, then add yourself"
 *   - complement = target - num
 *   - If complement exists in map → add its frequency to count
 *   - Then add current number to map
 *
 *   Order matters! Check BEFORE adding to avoid self-pairing
 *   Map stores frequency to handle duplicates correctly
 *
 * Time Complexity: O(n) - Single pass using HashMap
 * Space Complexity: O(n) - HashMap to store element frequencies
 */
import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println("Number of pairs: " + countPairs(arr, target)); // Output: 3
    }

    private static int countPairs(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

}
