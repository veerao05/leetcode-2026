package commonly.asked;

/*
 * Problem: Two Sum (LeetCode 1)
 * Find a pair of numbers in array that add up to target sum.
 *
 * Input: An array of integers and a target sum
 * Output: Pair of numbers that add up to target
 *
 * Example:
 *   Input: nums = {8, 7, 2, 5, 3, 1}, target = 10
 *   Output: (8, 2), (7, 3)
 *
 * Memory Trick:
 *   "Look for complement in map"
 *   - complement = target - current
 *   - If complement in map → found pair!
 *   - Then add current to map
 *
 *   Order: Check BEFORE adding to avoid self-pair
 *   Pattern: for each num → check → add
 *
 * Time Complexity: O(n) - Single pass using HashMap
 * Space Complexity: O(n) - HashMap stores elements
 */
import java.util.HashMap;
import java.util.Map;

public class FindPair {
    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 5, 3, 1};
        int target = 10;
        boolean found = false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println("pair found::" + nums[i] + " " + (target - nums[i]));
            }
            map.put(nums[i], i);
            found = true;

        }
        if (!found) {
            System.out.println("Pair not found in the array");
        }


    }
}
