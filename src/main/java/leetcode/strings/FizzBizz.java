package leetcode.strings;

/*
 * Problem: FizzBuzz (LeetCode 412)
 * For numbers 1 to n, print:
 *   - "FizzBuzz" if divisible by both 3 and 5
 *   - "Fizz" if divisible by 3 only
 *   - "Buzz" if divisible by 5 only
 *   - The number itself otherwise
 *
 * Input: An integer n
 * Output: List of strings following FizzBuzz rules
 *
 * Example:
 *   Input: n = 15
 *   Output: [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
 *
 * Key Insight:
 *   - Check divisibility by BOTH 3 and 5 first (order matters!)
 *   - Memory trick: "3 = Fizz, 5 = Buzz, 15 = FizzBuzz"
 *
 * Time Complexity: O(n) - Single loop from 1 to n
 * Space Complexity: O(n) - Result list stores n strings
 */
import java.util.ArrayList;
import java.util.List;

public class FizzBizz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
