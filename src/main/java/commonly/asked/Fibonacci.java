package commonly.asked;

/*
 * Problem: Fibonacci Number (LeetCode 509)
 * Generate the first n numbers of the Fibonacci sequence.
 * Each number is the sum of the two preceding ones.
 *
 * Input: Number of Fibonacci numbers to generate
 * Output: First n Fibonacci numbers
 *
 * Example:
 *   Input: num = 5
 *   Output: 0, 1, 1, 2, 3
 *
 * Memory Trick:
 *   "Keep 3 variables, shift left"
 *   - n3 = n1 + n2 (new value)
 *   - Then: n1 = n2, n2 = n3 (shift window)
 *
 *   Pattern: 0, 1, 1, 2, 3, 5, 8, 13, 21...
 *   F(n) = F(n-1) + F(n-2)
 *
 * Time Complexity: O(n) - Single loop
 * Space Complexity: O(1) - Only three variables
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n1=0,n2=0,n3=1;
        int num=5;
        for(int i=0;i<num;i++){
            n1=n2;
            n2=n3;
            n3=n1+n2;
            System.out.println(n1+" ");
        }
    }
}
