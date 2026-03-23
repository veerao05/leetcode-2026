package leetcode;

/*
 * Problem: Move All Negative Numbers to One Side
 * Rearrange array so all negative numbers are on the left and positive on the right.
 *
 * Input: An array of positive and negative integers
 * Output: Array with all negatives on left, positives on right
 *
 * Example:
 *   Input: {-12, 11, -13, -5, 6, -7, 5, -3, -11}
 *   Output: {-12, -11, -13, -5, -3, -7, 5, 6, 11}
 *
 * Memory Trick:
 *   "Two pointers: left finds positives, right finds negatives, SWAP"
 *   - left < 0 and right < 0 → move left
 *   - left > 0 and right < 0 → SWAP, move both
 *   - left < 0 and right > 0 → already correct, move right
 *   - both positive → move both
 *
 *   Like partitioning in QuickSort!
 *
 * Time Complexity: O(n) - Two-pointer approach
 * Space Complexity: O(1) - In-place rearrangement
 */
import java.util.Arrays;

public class MovePositiveAndNegativeNos {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5,
                6, -7, 5, -3, -11};
        shiftArr(arr, 0, arr.length - 1);
        Arrays.stream(arr).boxed().forEach(System.out::println);
    }

    private static void shiftArr(int[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            } else if (arr[left] > 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] < 0 && arr[right] > 0) {
                right--;
            } else {
                left++;
                right--;
            }
        }
    }
}
