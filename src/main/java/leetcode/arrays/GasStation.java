package leetcode.arrays;

/*
 * Problem: Gas Station (LeetCode 134)
 * There are n gas stations in a circular route. You start with an empty tank.
 * Find the starting station index to complete the circuit, or -1 if impossible.
 *
 * Input:
 *   - gas[i]: Amount of gas at station i
 *   - cost[i]: Gas needed to travel from station i to station i+1
 *
 * Output: Starting station index to complete circuit, or -1 if not possible
 *
 * Example:
 *   Input:  gas  = {1, 2, 3, 4, 5}
 *           cost = {3, 4, 5, 1, 2}
 *   Output: 3 (start at station 3)
 *
 * Key Insight:
 *   - If total gas >= total cost, a solution EXISTS
 *   - If we can't reach station i+1 from current start, new start = i+1
 *   - Memory trick: "If tank goes negative, restart from next station"
 *
 * Time Complexity: O(n) - Single pass through arrays
 * Space Complexity: O(1) - Only uses variables
 */
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += gas[i];
            if (totalCost > totalGas) return -1;
        }

        int currentGas = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;

            }
        }
        return startIndex;
    }
}
