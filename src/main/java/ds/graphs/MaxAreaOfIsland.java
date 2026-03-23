package ds.graphs;

/*
 * PROBLEM: Max Area of Island (LeetCode 695) https://leetcode.com/problems/max-area-of-island/description/
 * Given a 2D grid of 0s (water) and 1s (land), find the maximum area of an island.
 * An island is a group of 1s connected horizontally or vertically (4-directional).
 * Area = number of 1s in the island.
 *
 * APPROACH: DFS (Depth First Search)
 *
 * ALGORITHM (Pseudocode):
 * 1. Initialize maxArea = 0
 * 2. Traverse entire grid (nested loops):
 *    - If cell is 1 (land):
 *      a. Run DFS to calculate area of this island
 *      b. Update maxArea = max(maxArea, current island area)
 * 3. Return maxArea
 *
 * DFS Helper Function:
 * 1. Base Case: If out of bounds OR cell is 0 (water/visited), return 0
 * 2. Mark current cell as visited (set to 0)
 * 3. Initialize area = 1 (current cell counts)
 * 4. Recursively explore 4 directions (up, down, right, left)
 * 5. Add area from all 4 directions
 * 6. Return total area
 *
 * KEY INSIGHT: Mark visited cells as 0 to avoid counting same cell twice
 *
 * TIME COMPLEXITY: O(M × N) where M = rows, N = columns
 *                  - Visit each cell at most once
 *
 * SPACE COMPLEXITY: O(M × N)
 *                   - Recursion stack can go as deep as M×N in worst case (entire grid is one island)
 */

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        // Step 1: Traverse entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // Step 2: If land found, calculate island area
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        // Step 3: Return maximum area found
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {

        // Base Case: Out of bounds OR water/visited cell
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return 0;
        }

        // Step 1: Mark current cell as visited
        grid[i][j] = 0;

        // Step 2: Count current cell
        int area = 1;

        // Step 3: Explore all 4 directions and accumulate area
        area += dfs(grid, i - 1, j);  // Up
        area += dfs(grid, i + 1, j);  // Down
        area += dfs(grid, i, j + 1);  // Right
        area += dfs(grid, i, j - 1);  // Left

        // Step 4: Return total area of this island
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();

        int[][] grid5 = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 0, 1}
        };
        System.out.println("Test Case 5 - Max Area: " + solution.maxAreaOfIsland(grid5));
        // Expected Output: 6 (left island has 6 connected 1s)
    }
}