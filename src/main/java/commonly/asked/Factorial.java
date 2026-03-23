package commonly.asked;

/*
 * Problem: Calculate Factorial of a Number
 * Factorial n! = n * (n-1) * (n-2) * ... * 1
 *
 * Input: A non-negative integer n
 * Output: n! (factorial of n)
 *
 * Example:
 *   Input: n = 5
 *   Output: 120 (5! = 5 * 4 * 3 * 2 * 1)
 *
 * Memory Trick:
 *   "Multiply from 1 to n"
 *   - Iterative: factorial *= i (for i = 1 to n)
 *   - Recursive: n * factorial(n-1), base: 0! = 1
 *
 *   Edge cases:
 *   - 0! = 1 (by definition)
 *   - Negative → undefined
 *   - Use long for large n (overflow risk!)
 *
 * Time Complexity: O(n) - Single loop from 1 to n
 * Space Complexity: O(1) - Only uses a variable
 */
public class Factorial {
    public static void main(String[] args) {
        long factorial = 1;
        int n = 5;
        if(n<1) System.out.println("factorial cant be for negative number ");
        if(n==0) System.out.println("factorial of 0 is 1");
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Factorial of a number::" + factorial);
    }
}
