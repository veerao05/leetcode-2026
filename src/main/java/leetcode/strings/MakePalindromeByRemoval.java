package leetcode.strings;

/*
 * Problem: Valid Palindrome II (LeetCode 680)
 * Given a string, return true if it can become a palindrome
 * by removing AT MOST ONE character.
 *
 * Input: A string s
 * Output: true if can become palindrome by removing at most 1 char
 *
 * Example:
 *   Input: "OMOM" → Remove 'O' → "MOM" → true
 *   Input: "abca" → Remove 'b' → "aca" → true
 *   Input: "abc"  → Can't fix with one removal → false
 *
 * Approach:
 *   - Two pointers from both ends
 *   - On mismatch: try skipping left OR right char
 *   - Memory trick: "Mismatch? Try skipping one side"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MakePalindromeByRemoval {
    public static void main(String[] args) {
        System.out.println(canMakePalindrome("OMOM"));  // true
        System.out.println(canMakePalindrome("abca"));  // true
        System.out.println(canMakePalindrome("abc"));   // false
    }

    private static boolean canMakePalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                // Mismatch! Try removing left char OR right char
                return isPalindrome(str, left + 1, right) ||
                        isPalindrome(str, left, right - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
