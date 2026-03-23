package leetcode.arrays;

/*
 * Problem: Merge Sorted Array (LeetCode 88)
 * Merge nums2 into nums1 as one sorted array.
 * nums1 has enough space to hold additional elements from nums2.
 *
 * Input: Two sorted arrays, nums1 with extra space, nums2
 * Output: nums1 containing all elements in sorted order
 *
 * Example:
 *   Input: nums1 = {1, 2, 3, 0, 0, 0}, m = 3
 *          nums2 = {2, 5, 6}, n = 3
 *   Output: {1, 2, 2, 3, 5, 6}
 *
 * Memory Trick:
 *   "Merge from END" - Fill from back to avoid overwriting
 *   - Better O(1) space approach: Start from end of nums1
 *   - Compare largest elements, place at back
 *   - i = m-1, j = n-1, k = m+n-1
 *   - This avoids needing extra array!
 *
 *   Current code uses O(m+n) extra space.
 *
 * Time Complexity: O(m + n) - Single pass through both arrays
 * Space Complexity: O(m + n) - Temporary result array (can be O(1))
 */
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] res = new int[nums1.length];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];

        }
        System.arraycopy(res, 0, nums1, 0, res.length);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
