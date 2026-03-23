package leetcode;

/*
 * Problem: Factorial of a Large Number
 * Calculate factorial of large numbers that exceed primitive data type limits.
 *
 * Input: A positive integer N
 * Output: N! (factorial of N)
 *
 * Example:
 *   Input: N = 100
 *   Output: 93326215443944152681699238856266700490715968264381621468592963895...
 *
 * Memory Trick:
 *   "BigInteger for overflow-safe multiplication"
 *   - long overflows after ~20!
 *   - BigInteger: unlimited precision
 *   - num.multiply(BigInteger.valueOf(i))
 *
 *   Pattern: Start with BigInteger("1"), multiply in loop
 *
 * Time Complexity: O(n) - Loop from 2 to N
 * Space Complexity: O(log(n!)) - BigInteger digits grow
 */
import java.math.BigInteger;

public class FactorialOfLargeNumber {
    public static void main(String[] args) {
        int N = 100;
        BigInteger num = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            num = num.multiply(BigInteger.valueOf(i));

        }
        System.out.println(num);
    }
}
