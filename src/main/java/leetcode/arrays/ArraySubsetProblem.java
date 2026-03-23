package leetcode.arrays;

/*
 * Problem: Check if Array is Subset of Another Array
 * Determine if all elements of arr2 are present in arr1.
 *
 * Input: Two arrays of integers
 * Output: True if arr2 is a subset of arr1, false otherwise
 *
 * Example:
 *   Input: arr1 = {11, 1, 13, 21, 3, 7}, arr2 = {11, 3, 7, 1}
 *   Output: true
 *
 * Memory Trick:
 *   "Put arr1 in Set, check if arr2 elements exist"
 *   - HashSet for O(1) lookup
 *   - Add all arr1 elements to set
 *   - For each arr2 element, check if in set
 *   - If any not found → not a subset
 *
 *   Note: Bug in code - should check arr2[j], not arr1[j]
 *
 * Time Complexity: O(m + n) - Build set + check elements
 * Space Complexity: O(m) - HashSet stores arr1
 */
import java.util.HashSet;
import java.util.Set;

public class ArraySubsetProblem {
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        System.out.println("Contains subset:: " + isSubset(arr1, arr2));

    }

    private static boolean isSubset(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        Set<Integer> set = new HashSet<>();

        for (int k : arr1) {
            set.add(k);
        }

        for (int j = 0; j < n; j++) {
            if (!set.contains(arr1[j])) return false;
        }
        return true;
    }
}
