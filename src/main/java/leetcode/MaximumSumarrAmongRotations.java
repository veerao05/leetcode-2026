package leetcode;

/*
 * Problem: Maximum Sum of i*arr[i] Among All Rotations
 * Find the maximum value of sum(i*arr[i]) among all rotations of the array.
 *
 * Input: An array of integers
 * Output: Maximum sum of i*arr[i] for any rotation
 *
 * Example:
 *   Input: {8, 3, 1, 2}
 *   Output: 29 (rotation {1, 2, 8, 3} gives 0*1 + 1*2 + 2*8 + 3*3 = 29)
 *
 * Memory Trick:
 *   Current: O(n²) brute force - try all rotations
 *
 *   Better O(n) approach using math:
 *   - Let R0 = initial sum, S = sum of all elements
 *   - R1 = R0 + S - n*arr[n-1] (each rotation formula)
 *   - Each element's index increases by 1, except last goes to 0
 *
 *   (i+j) % n simulates rotation offset
 *
 * Time Complexity: O(n^2) - Nested loops (can be O(n))
 * Space Complexity: O(1) - Only variables
 */
public class MaximumSumarrAmongRotations {
    public static void main(String[] args) {
        int arr[] = {8, 3, 1, 2};
        System.out.println(maxSum(arr));

    }

    private static int maxSum(int[] arr) {
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int currSum=0;
            for(int j=0;j< arr.length;j++){
                int index= (i+j)%arr.length;
                currSum+=j*arr[index];
                System.out.println(" index:: "+index+" currSum:: "+currSum);
            }
            res=Math.max(currSum,res);
        }
        return res;
    }
}
