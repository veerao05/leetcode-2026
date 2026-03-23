package leetcode.strings;

/*
 * Problem: Valid Palindrome (LeetCode 125)
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase and removing all non-alphanumeric characters,
 * it reads the same forward and backward.
 *
 * Input: A string s
 * Output: true if it is a palindrome, false otherwise
 *
 * Example:
 *   Input: "A man, a plan, a canal: Panama"
 *   Output: true (becomes "amanaplanacanalpanama")
 *
 *   Input: "race a car"
 *   Output: false (becomes "raceacar")
 *
 * Approach:
 *   - Two pointers from both ends
 *   - Skip non-alphanumeric characters
 *   - Compare lowercase characters
 *   - Memory trick: "Skip junk, compare lowercase"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MakePalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));  // true
        System.out.println(isPalindrome("race a car"));                       // false
        System.out.println(isPalindrome("mom"));                              // true
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare lowercase
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
