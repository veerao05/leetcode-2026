package leetcode.strings;

/*
 * Problem: Caesar Cipher (Shift Cipher)
 * Shift each letter in a string by a given count (left or right).
 *
 * Input: A string and shift count
 * Output: Encrypted string with letters shifted
 *
 * Example:
 *   Input: "ab", shift = 1
 *   Right shift: "bc" (a→b, b→c)
 *   Left shift: "za" (a→z, b→a)
 *
 * Approach:
 *   - Find index of each char in alphabet
 *   - Right shift: (index + count) % 26
 *   - Left shift: (index - count) % 26, handle negative
 *
 * Memory Trick:
 *   "Modulo 26 wraps around alphabet"
 *   - Right: (index + shift) % 26
 *   - Left: (index - shift + 26) % 26 (add 26 to handle negative)
 *   - Think of alphabet as a circular wheel
 *
 * Time Complexity: O(n) - Process each character once
 * Space Complexity: O(n) - StringBuilder for result
 */
public class CipherString {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        //System.out.println("LeftShiftCipher:: " + LeftShiftCipher("adef", 1));
        System.out.println("RightShiftCipher:: " + RightShiftCipher("adef", 1));

    }

    private static String LeftShiftCipher(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.toLowerCase().indexOf(text.charAt(i));
            int pos = (index - count) % 26;
            if (pos < 0) {
                sb.append(alphabet.charAt(alphabet.length() + pos));
            } else {
                sb.append(alphabet.charAt(pos));
            }

        }
        return sb.toString().toLowerCase();
    }

    private static String RightShiftCipher(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int index = alphabet.toLowerCase().indexOf(text.charAt(i));
            int pos = (index + count) % 26;
            sb.append(alphabet.charAt(pos));

        }
        return sb.toString().toLowerCase();
    }
}
