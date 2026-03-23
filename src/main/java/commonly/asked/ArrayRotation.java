package commonly.asked;

/*
 * Problem: Rotate Array (LeetCode 189)
 * Rotate array elements by given positions to left or right.
 *
 * Input: An array and number of positions to rotate
 * Output: Rotated array
 *
 * Example:
 *   Input: arr = {1, 2, 3, 4, 5, 6, 7}, num = 2
 *   Left Rotation: {3, 4, 5, 6, 7, 1, 2}
 *   Right Rotation: {6, 7, 1, 2, 3, 4, 5}
 *
 * Memory Trick:
 *   Current: O(n * k) - shift one position k times
 *   Better O(n) approach - "Reverse trick":
 *   - Right rotate by k:
 *     1. Reverse entire array
 *     2. Reverse first k elements
 *     3. Reverse remaining n-k elements
 *
 *   Example: [1,2,3,4,5], k=2
 *   → [5,4,3,2,1] → [4,5,3,2,1] → [4,5,1,2,3]
 *
 * Time Complexity: O(n * k) - Nested loops (can be O(n))
 * Space Complexity: O(1) - In-place rotation
 */
import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int num = 2;
        //leftRotation(arr, num);
        rightRotation(arr, num);

    }

    private static void leftRotation(int[] arr, int num) {
        for (int i = 0; i < num; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
        System.out.println("Input Array After Left Rotation By " + num + " Positions :");
        System.out.println(Arrays.toString(arr));
    }

    private static void rightRotation(int[] arr, int num) {
        for (int i = 0; i < num; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
        System.out.println("Input Array After right Rotation By " + num + " Positions :");
        System.out.println(Arrays.toString(arr));
    }
}
