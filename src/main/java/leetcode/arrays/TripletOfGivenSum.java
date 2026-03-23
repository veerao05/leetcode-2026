package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class TripletOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 22;

        find3Numbers(arr, sum);
    }

    static void find3Numbers(int[] arr, int sum) {

        for (int i = 0; i < arr.length - 2; i++) {
            int curSum = sum - arr[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(curSum - arr[j])) {
                    System.out.println("Found triplets::" + arr[i] + " " + arr[j] + " " + (curSum - arr[j]));
                }
                set.add(arr[j]);

            }
        }

    }
}
