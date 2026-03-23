package ds.graphs;

/*
 * PROBLEM: Number of Islands (LeetCode 200) https://leetcode.com/problems/number-of-islands/description/
 * Given a 2D grid of 0s (water) and 1s (land), count the number of islands.
 * An island is a group of 1s connected horizontally or vertically (4-directional).
 *
 * APPROACH: DFS (Depth First Search)
 *
 * ALGORITHM (Pseudocode):
 * 1. Initialize island count = 0
 * 2. Traverse the entire grid (nested loops):
 *    - If cell is 1 (land):
 *      a. Increment island count (found a new island)
 *      b. Run DFS to mark the entire island as visited
 * 3. Return total island count
 *
 * DFS Helper Function:
 * 1. Base Case: If out of bounds OR cell is 0 (water/visited), return
 * 2. Mark current cell as visited (set to 0)
 * 3. Recursively explore 4 directions (up, down, right, left)
 *
 * KEY INSIGHT:
 * - Each time we find a '1', it's a NEW island (we increment counter)
 * - DFS marks the ENTIRE island as visited (changes all connected 1s to 0s)
 * - This ensures we don't count the same island multiple times
 *
 * TIME COMPLEXITY: O(M × N) where M = rows, N = columns
 *                  - Visit each cell at most once
 *
 * SPACE COMPLEXITY: O(M × N)
 *                   - Recursion stack can go as deep as M×N in worst case (entire grid is one island)
 */

public class NoOfIsland {

    public int noOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int island = 0;

        // Step 1: Traverse entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // Step 2: Found unvisited land (new island)
                if (grid[i][j] == 1) {
                    island++;  // Increment island count
                    dfs(grid, i, j);  // Mark entire island as visited
                }
            }
        }

        // Step 3: Return total number of islands
        return island;
    }

    private void dfs(int[][] grid, int i, int j) {

        // Base Case: Out of bounds OR water/visited cell
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        // Step 1: Mark current cell as visited
        grid[i][j] = 0;

        // Step 2: Explore all 4 directions
        dfs(grid, i - 1, j);  // Up
        dfs(grid, i + 1, j);  // Down
        dfs(grid, i, j + 1);  // Right
        dfs(grid, i, j - 1);  // Left
    }

    public static void main(String[] args) {
        NoOfIsland solution = new NoOfIsland();

        int[][] grid5 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("No of Island: " + solution.noOfIsland(grid5));
        // Expected Output: 3
        /*
         * Island 1: Top-left (4 connected 1s)
         * Island 2: Middle (1 single cell)
         * Island 3: Bottom-right (2 connected 1s)
         */
    }
}