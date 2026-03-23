package leetcode.arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findChocolate(arr, m));
    }

    private static int findChocolate(int[] arr, int m) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        if (m == 0 || n == 0) {
            System.out.println("Nothing to share");
            return 0;
        }
        if (n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
            int min = arr[i];
            int max = arr[i + m - 1];
            int diff = max - min;
            if (diff < res) {
                res = diff;
            }
        }
        return res;
    }
}
