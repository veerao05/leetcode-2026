package leetcode.strings;

/*
 * Problem: Split String by Character Type
 * Separate a string into alphabets, numbers, and special characters.
 *
 * Input: A string containing mixed characters
 * Output: Three separate strings - alphabets, numbers, special chars
 *
 * Example:
 *   Input: "geeks01$$for02geeks03!@!!"
 *   Output:
 *     special: 01$$02030!@!!
 *     num: 010203
 *     alpha: geeksforgeeks
 *
 * Memory Trick:
 *   "Three buckets, classify each char"
 *   - Character.isDigit(ch) → numbers
 *   - Character.isAlphabetic(ch) → letters
 *   - else → special characters
 *
 *   Note: Bug in code - digits are added to both num AND special
 *         (missing 'else if' before isAlphabetic)
 *
 * Time Complexity: O(n) - Single pass through string
 * Space Complexity: O(n) - Three StringBuffers store all chars
 */
public class StringSplitter {
    public static void main(String[] args) {
        String str = "geeks01$$for02geeks03!@!!";
        splitString(str);

    }

    private static void splitString(String str) {
        StringBuffer special = new StringBuffer();
        StringBuffer num = new StringBuffer();
        StringBuffer alpha = new StringBuffer();

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                num.append(ch);
            }
            if (Character.isAlphabetic(ch)) {
                alpha.append(ch);
            } else {
                special.append(ch);
            }
        }
        System.out.println("special:: " + special);
        System.out.println("num:: " + num);
        System.out.println("alpha:: " + alpha);
    }
}
