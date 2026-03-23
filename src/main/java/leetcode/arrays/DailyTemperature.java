package leetcode.arrays;

/*
 * Problem: Daily Temperatures (LeetCode 739)
 * Given daily temperatures, find how many days until a warmer temperature.
 * If no future day is warmer, put 0.
 *
 * Input: Array of daily temperatures
 * Output: Array where each element is days to wait for warmer temperature
 *
 * Example:
 *   Input:  {73, 74, 75, 71, 69, 72, 76, 73}
 *   Output: {1,  1,  4,  2,  1,  1,  0,  0}
 *
 * Approach 1 (Brute Force):
 *   - For each day, look forward until warmer day found
 *   - Time Complexity: O(n²)
 *   - Space Complexity: O(1)
 *
 * Approach 2 (Stack - Optimal):
 *   - Stack holds indices of "waiting" days (monotonic decreasing temps)
 *   - When hot day arrives, pop and resolve all colder waiting days
 *   - Memory trick: "Stack waits for warmth. Hot day arrives → settle all debts!"
 *   - Time Complexity: O(n) - each element pushed and popped at most once
 *   - Space Complexity: O(n) - stack can hold all elements
 */
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int dailyTemperatures[] = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println("Brute Force Approach:");
        int[] result1 = dailyTemperaturesBruteForce(dailyTemperatures);
        Arrays.stream(result1).forEach(System.out::println);

        System.out.println("\nStack Approach:");
        int[] result2 = dailyTemperaturesStack(dailyTemperatures);
        Arrays.stream(result2).forEach(System.out::println);
    }

    // Approach 1: Brute Force - O(n²) time, O(1) space
    private static int[] dailyTemperaturesBruteForce(int[] temp) {
        int result[] = new int[temp.length];
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] > temp[i]) {
                    result[i] = j - i;
                    break;  // Stop at FIRST warmer day
                }
            }
        }
        return result;
    }

    // Approach 2: Stack - O(n) time, O(n) space
    private static int[] dailyTemperaturesStack(int[] temp) {
        int[] result = new int[temp.length];
        Stack<Integer> stack = new Stack<>();  // Stores INDICES of waiting days

        for (int i = 0; i < temp.length; i++) {
            // While stack not empty AND today is warmer than waiting day
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int waitingDay = stack.pop();
                result[waitingDay] = i - waitingDay;
            }
            stack.push(i);  // This day now waits for a warmer day
        }
        // Days remaining in stack have no warmer future day (result stays 0)
        return result;
    }
}
