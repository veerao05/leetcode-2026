package leetcode.arrays;

/*
 * Problem: Intersection of Two Arrays (LeetCode 349)
 * Find common elements between two arrays.
 *
 * Input: Two arrays of integers
 * Output: Elements present in both arrays
 *
 * Example:
 *   Input: arr1 = {11, 1, 13, 21, 3, 7}, arr2 = {11, 3, 7, 1}
 *   Output: {11, 3, 7, 1}
 *
 * Memory Trick:
 *   "Put arr1 in Set, find matches in arr2"
 *   - Add arr1 to HashSet (for O(1) lookup)
 *   - For each arr2 element, check if in set
 *   - If found, add to result set
 *
 *   LeetCode 349: Unique intersection
 *   LeetCode 350: Include duplicates (use HashMap with counts)
 *
 * Time Complexity: O(m + n) - Traversing both arrays
 * Space Complexity: O(m) - HashSet for arr1
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        System.out.println("Contains intersection:: ");
        arrayIntersect(arr1, arr2);
    }

    private static void arrayIntersect(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int element : arr1) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (int element : arr2) {
            if (map.containsKey(element)) {
                map.put(element, map.getOrDefault(element, 0) - 1);
                set.add(element);
            }
        }

        set.stream().forEach(System.out::println);

    }
}
