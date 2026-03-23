package leetcode;

/*
 * Problem: Maximum Product Subarray (LeetCode 152)
 * Find the contiguous subarray with the maximum product.
 *
 * Input: An array of integers (can have negative numbers and zero)
 * Output: Maximum product of any contiguous subarray
 *
 * Example:
 *   Input: {1, -2, -3, 0, 7, -8, -2}
 *   Output: 112 (subarray {7, -8, -2})
 *
 * Memory Trick (O(n) approach):
 *   "Track BOTH max AND min" - negative × negative = positive!
 *   - maxProd = max(num, num*maxProd, num*minProd)
 *   - minProd = min(num, num*maxProd, num*minProd)
 *   - A negative min can become max when multiplied by negative!
 *
 *   Current code is O(n²) brute force. Optimal is O(n).
 *
 * Time Complexity: O(n^2) - Nested loops (brute force)
 * Space Complexity: O(1) - Only uses variables
 */
public class MaximumProductContinousSubarray {
    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println("Maximum Sub array product is "
                + maxSubarrayProduct(arr));
    }

    private static int maxSubarrayProduct(int[] arr) {
        int res=arr[0];
        int n = arr.length;
        for(int i=0;i<n;i++){
            int mul=arr[i];
            for(int j=i+1;j<n;j++){
                res=Math.max(res,mul);
                mul*=arr[j];
            }
            res =  Math.max(res,mul);
        }
        return res;
    }
}
