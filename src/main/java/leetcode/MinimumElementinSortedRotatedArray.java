package leetcode;

/*
 * Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)
 * Find the minimum element in a sorted array that has been rotated.
 *
 * Input: A sorted array that has been rotated at some pivot
 * Output: The minimum element in the array
 *
 * Example:
 *   Input: {5, 6, 1, 2, 3, 4}
 *   Output: 1
 *
 * Memory Trick (O(log n) Binary Search):
 *   "Min is at the rotation point"
 *   - If arr[mid] > arr[right]: min is in right half
 *   - Else: min is in left half (including mid)
 *   - Look for where sorted order breaks
 *
 *   Current code is O(n) using stream.
 *   Binary search: Compare mid with right endpoint!
 *
 * Time Complexity: O(n) - Stream (can be O(log n) with binary search)
 * Space Complexity: O(1) - No extra space used
 */
import java.util.Arrays;
import java.util.Comparator;

public class MinimumElementinSortedRotatedArray {
    public static void main(String[] args) {
        //int arr[] = {5, 6, 1, 2, 3, 4};
        int arr[] = {1, 6, 1, 2, 3, 4};
        Arrays.stream(arr).boxed().min(Comparator.comparingInt(Integer::intValue)).ifPresent(System.out::println);
    }
}
