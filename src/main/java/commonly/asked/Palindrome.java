package commonly.asked;

/*
 * Problem: Valid Palindrome (LeetCode 125 simplified)
 * A palindrome reads the same forwards and backwards.
 *
 * Input: A string
 * Output: True if palindrome, false otherwise
 *
 * Example:
 *   Input: "mom"
 *   Output: true (reads same both ways)
 *
 * Memory Trick:
 *   Two approaches:
 *   1. "Reverse and compare" (current): O(n) space
 *   2. "Two pointers" (better): O(1) space
 *      - left = 0, right = n-1
 *      - While left < right: compare chars
 *      - If all match → palindrome
 *
 *   For alphanumeric only: skip non-alphanumeric chars
 *
 * Time Complexity: O(n) - Traverse string once
 * Space Complexity: O(n) - StringBuilder (can be O(1) with two pointers)
 */
public class Palindrome {
    public static void main(String[] args) {
        String original = "mom";
        boolean found = false;
        StringBuilder reverse = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            reverse.append(original.charAt(i));
        }
        if (original.equals(reverse.toString())) {
            System.out.println("palindrome");
            found = true;
        }
        if (!found) System.out.println("No palindrme");
    }
}
