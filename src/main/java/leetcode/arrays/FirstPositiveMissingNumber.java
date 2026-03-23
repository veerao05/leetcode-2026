package leetcode.arrays;

public class FirstPositiveMissingNumber {
    public static void main(String[] args) {
        int arr[] = {3, 4, -1, 1};
        System.out.println("First Missing positive number::" + firstPositiveMissingNumber(arr));

    }

    private static int firstPositiveMissingNumber(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            if (index > n) continue;
            index = index-1;
            if (arr[index] > 0) arr[index] = -arr[index];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) return i + 1;
        }
        return n + 1;
    }
}
