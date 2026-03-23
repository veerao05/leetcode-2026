package commonly.asked;

/*
 * Problem: Reverse String & Reverse Words (LeetCode 344, 151)
 * 1. Reverse a string character by character
 * 2. Reverse the order of words in a sentence
 *
 * Input: A string or sentence
 * Output: Reversed string / sentence with reversed word order
 *
 * Example:
 *   Input: "hello" → Output: "olleh"
 *   Input: "hello world" → Output: "world hello"
 *
 * Memory Trick:
 *   1. Reverse chars: "Loop from end to start"
 *      - for(i = n-1; i >= 0; i--) append char
 *      - Or: Two pointers swap in-place
 *
 *   2. Reverse words: "Split, iterate reverse, join"
 *      - Split by space → array of words
 *      - Loop from end → append each word
 *
 * Time Complexity: O(n) - Traverse string once
 * Space Complexity: O(n) - StringBuilder stores result
 */
public class StringReverse {
    public static void main(String[] args) {
        String word = "hello";
        StringBuilder result = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }
        System.out.println(result);

        String sentence = "hello world";
        String[] arr = sentence.split(" ");
        StringBuilder latest = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            latest.append(arr[i] +" ");
        }
        System.out.println(latest);
    }
}
