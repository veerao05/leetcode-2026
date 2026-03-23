package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(majorElement(arr));
    }

    private static int majorElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);

            if (map.get(val) > arr.length / 2) {
                return val;
            }
        }

        return -1;
    }
}
