package leetcode.arrays;

/*
 * Problem: Contains Duplicate (LeetCode 217)
 * Check if any element appears more than once in the array.
 *
 * Input: An array of integers
 * Output: True if duplicates exist, false otherwise
 *
 * Example:
 *   Input: {1, 2, 3, 1}
 *   Output: true (1 appears twice)
 *
 * Memory Trick:
 *   "distinct().count() != length means duplicates"
 *   - If all unique: distinct count == array length
 *   - If duplicates: distinct count < array length
 *
 *   Alternative: HashSet.add() returns false on duplicate
 *   for(num : arr) if(!set.add(num)) return true;
 *
 * Time Complexity: O(n) - Stream distinct operation
 * Space Complexity: O(n) - Set created internally by distinct()
 */
import java.util.Arrays;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};

        System.out.println("containDuplicate::" + containDuplicate(arr));

    }

    private static boolean containDuplicate(int[] arr) {
        return Arrays.stream(arr).distinct().count() != arr.length;
    }
}
