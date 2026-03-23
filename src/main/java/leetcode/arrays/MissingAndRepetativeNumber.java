package leetcode.arrays;

/*
 * Problem: Find Missing and Repeating Number
 * Given an array of n integers where elements are from 1 to n,
 * one number is missing and one is repeated. Find both.
 *
 * Input: Array of n integers (1 to n with one missing, one duplicate)
 * Output: The repeating number and the missing number
 *
 * Example:
 *   Input: {4, 3, 6, 2, 1, 1}
 *   Output: Repeating = 1, Missing = 5
 *
 * Approach (HashMap):
 *   1. Add elements to map, detect duplicate when already present
 *   2. Loop 1 to n, find which number is not in map → missing
 *
 * Memory Trick:
 *   "Two loops: first finds REPEATING, second finds MISSING"
 *   - Loop 1: Add to map, if already exists → REPEATING
 *   - Loop 2: Check 1 to n (not array!), if not in map → MISSING
 *
 *   Key Bug to Avoid: Second loop must iterate 1 to n, NOT over array!
 *
 * Time Complexity: O(n) - Two passes
 * Space Complexity: O(n) - HashMap stores n elements
 */
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepetativeNumber {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};

        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer ele : arr) {
            if (map.get(ele) == null) {
                map.put(ele, true);
            }
            else {
                System.out.println("Repeating::" + ele);
            }
        }
        // Loop through expected range 1 to n, not the array!
        for (int i = 1; i <= arr.length; i++) {
            if (map.get(i) == null) {
                System.out.println("Missing::" + i);
            }
        }
    }
}
