package commonly.asked;

/*
 * Problem: Find Second Highest Element in Array
 * Find the second largest number in an unsorted array.
 *
 * Input: An array of integers
 * Output: The second highest value
 *
 * Example:
 *   Input: {4, 5, 2, 1, 9, 7}
 *   Output: Highest = 9, Second Highest = 7
 *
 * Memory Trick:
 *   "Cascade down when new max found"
 *   - If num > highest:
 *       secondHighest = highest (demote old max)
 *       highest = num (promote new max)
 *   - Else if num > secondHighest:
 *       secondHighest = num
 *
 *   Key: When you find new max, OLD max becomes second!
 *
 * Time Complexity: O(n) - Single pass through array
 * Space Complexity: O(1) - Only two variables
 */
public class SecondHighest {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 1, 9, 7};
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;

            }
        }
        System.out.println("Highest" + highest + "seconf Highest::" + secondHighest);

    }
}
