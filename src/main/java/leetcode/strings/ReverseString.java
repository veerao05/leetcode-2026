package leetcode.strings;

/*
 * Problem: Reverse String (LeetCode 344)
 * Reverse a string in-place. The input is given as an array of characters.
 * Do not allocate extra space - modify the input array with O(1) extra memory.
 *
 * Input: A character array
 * Output: The same array reversed in-place
 *
 * Example:
 *   Input: ['h', 'e', 'l', 'l', 'o']
 *   Output: ['o', 'l', 'l', 'e', 'h']
 *
 * Approach:
 *   - Two pointers: left and right
 *   - Swap characters and move pointers toward center
 *   - Memory trick: "Swap from ends, meet in middle"
 *
 * Time Complexity: O(n) - Single pass through half the array
 * Space Complexity: O(1) - In-place swap, no extra space
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println(s1);  // olleh

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println(s2);  // hannaH
    }

    private static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
