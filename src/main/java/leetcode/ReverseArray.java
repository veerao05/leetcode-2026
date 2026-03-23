package leetcode;

/*
 * Problem: Reverse an Array
 * Reverse the elements of an array in-place using recursion.
 *
 * Input: An array of integers
 * Output: The same array with elements in reverse order
 *
 * Example:
 *   Input: {1, 2, 3, 4, 5, 6}
 *   Output: {6, 5, 4, 3, 2, 1}
 *
 * Memory Trick:
 *   "Swap ends, move inward" (recursive version)
 *   - Base case: start >= end
 *   - Swap arr[start] and arr[end]
 *   - Recurse with start+1, end-1
 *
 *   Iterative version: Two pointers, while(left < right)
 *
 * Time Complexity: O(n) - Each element visited once
 * Space Complexity: O(n/2) - Recursive call stack depth
 */
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int start = 0;
        int end = arr.length - 1;
        reverseArray(arr, start, end);
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        if (start >= end) return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }
}
