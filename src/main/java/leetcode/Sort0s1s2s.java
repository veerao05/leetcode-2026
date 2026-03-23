package leetcode;

/*
 * Problem: Sort Colors (LeetCode 75) - Dutch National Flag
 * Given an array containing only 0s, 1s, and 2s, sort it in-place.
 *
 * Input: An array containing only 0, 1, and 2
 * Output: Sorted array with all 0s first, then 1s, then 2s
 *
 * Example:
 *   Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 *   Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 *
 * Memory Trick:
 *   Two approaches:
 *   1. "Count and Fill" (current) - Count each, then fill
 *   2. "Three Pointers" (Dutch Flag) - Single pass:
 *      - low = 0, mid = 0, high = n-1
 *      - 0 → swap with low, low++, mid++
 *      - 1 → mid++
 *      - 2 → swap with high, high--
 *
 *   Think: "0s go left, 2s go right, 1s stay middle"
 *
 * Note: Bug in line 30: i <= n should be i < n
 *
 * Time Complexity: O(n) - Two passes (or one pass with 3 pointers)
 * Space Complexity: O(1) - Only uses counter/pointer variables
 */
import java.util.Arrays;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        //Arrays.stream(arr).boxed().sorted().forEach(System.out::println);
        sortArr(arr, n);
        Arrays.stream(arr).boxed().forEach(System.out::println);
    }

    private static void sortArr(int[] arr, int n) {
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (i = 0; i <= n; i++) {
            switch (arr[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;

            }
        }
        i = 0;
        while (cnt0 > 0) {
            arr[i++] = 0;
            cnt0--;
        }
        while (cnt1 > 0) {
            arr[i++] = 1;
            cnt1--;
        }
        while (cnt2 > 0) {
            arr[i++] = 2;
            cnt2--;
        }

    }
}
