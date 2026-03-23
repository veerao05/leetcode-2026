package leetcode.arrays;

/*
 * Problem: Remove Element (LeetCode 27)
 * Remove all occurrences of a given value from array in-place.
 * Return the new length of array (elements beyond new length don't matter).
 *
 * Input: An array of integers and a value to remove
 * Output: Modified array with value removed, returns count of remaining elements
 *
 * Example:
 *   Input: arr = {0, 1, 2, 2, 3, 0, 4, 2}, val = 2
 *   Output: {0, 1, 3, 0, 4, ...}, count = 5
 *
 * Memory Trick:
 *   "Keep pointer for non-target elements"
 *   - count = position for next "keeper"
 *   - If element != val, copy to arr[count], count++
 *   - Elements after count position don't matter
 *
 *   Same pattern as MoveZeroes (but skip instead of move to end)
 *
 * Time Complexity: O(n) - Single pass through array
 * Space Complexity: O(1) - In-place modification
 */
import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int val=2;
        removeElement(arr,val);
    }

    private static void removeElement(int[] arr, int val) {
        int count=0;
        for(int ele: arr){
            if(ele != val ){
                arr[count] = ele;
                count++;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
