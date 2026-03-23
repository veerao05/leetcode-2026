package leetcode;

/*
 * Problem: Minimum Platforms Required for Railway Station
 * Find the minimum number of platforms needed so no train waits.
 *
 * Input: Arrays of arrival and departure times of trains
 * Output: Minimum number of platforms required
 *
 * Example:
 *   Input: arr = {900, 940, 950, 1100, 1500, 1800}
 *          dept = {910, 1200, 1120, 1130, 1900, 2000}
 *   Output: 3
 *
 * Memory Trick:
 *   "Sort both, merge-style comparison"
 *   - Sort arrivals and departures separately
 *   - Two pointers: i for arrivals, j for departures
 *   - arrival <= departure → train arrives, count++, i++
 *   - arrival > departure → train departs, count--, j++
 *   - Track max count = minimum platforms needed
 *
 *   Think: "Event-driven counting"
 *
 * Time Complexity: O(n log n) - Due to sorting
 * Space Complexity: O(1) - Only variables
 */
import java.util.Arrays;

public class MinimumPlatformsForRailywayStation {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};

        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0, j = 0;
        int minimumPlatform = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i] <= dept[j]) {
                count++;
                minimumPlatform = Math.max(minimumPlatform, count);
                i++;

            } else if (arr[i] > dept[j]) {
                count--;
                j++;
            }
        }
        System.out.println("MinimumPlatformsForRailywayStation::"+minimumPlatform);
    }
}
