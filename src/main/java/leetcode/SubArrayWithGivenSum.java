package leetcode;

/*
 * Problem: Subarray Sum Equals K (LeetCode 560 variant)
 * Find a contiguous subarray that adds up to a given sum.
 *
 * Input: An array of integers and a target sum
 * Output: Starting and ending indices of the subarray with the given sum
 *
 * Example:
 *   Input: arr = {1, 4, 20, 3, 10, 5}, sum = 33
 *   Output: Indices 2 to 4 (20 + 3 + 10 = 33)
 *
 * Memory Trick:
 *   "Sliding window for positive arrays, HashMap for negatives"
 *   - Current code: O(n²) brute force
 *   - For positive only: Use sliding window O(n)
 *   - For mixed +/-: Use prefix sum + HashMap O(n)
 *     → Store prefix[i], look for prefix[i] - target
 *
 * Time Complexity: O(n^2) - Nested loops (brute force)
 * Space Complexity: O(1) - No extra space used
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int n = arr.length;
        subArraySum(arr, n, sum);

    }

    private static void subArraySum(int[] arr, int n, int sum) {
        for(int i=0;i< n;i++){
            int currentSum = arr[i];
            if(currentSum== sum){
                System.out.println("sum found at::"+i);
                return;
            }

            for(int j=i+1;j<n;j++){
                currentSum+=arr[j];
                if(currentSum == sum){
                    System.out.println("sum found at indices::"+ i + " " + j);
                    return;
                }
            }
        }
        System.out.println("No subArray found");
    }
}
