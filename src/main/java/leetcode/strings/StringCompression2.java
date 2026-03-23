package leetcode.strings;

public class StringCompression2 {
    public static void main(String[] args) {
        String word = "abbcdbe";
        compress(word);
    }

    private static void compress(String word) {

        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1) ) {
                count++;
            } else {
                sb.append(word.charAt(i)).append(count);
                count = 1;
            }
        }
        sb.append(word.charAt(word.length() - 1)).append(count);
        System.out.println(sb);
    }
}
