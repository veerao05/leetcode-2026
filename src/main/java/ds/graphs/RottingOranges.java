package ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * PROBLEM: Rotting Oranges (LeetCode 994)
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell
 * - 1 representing a fresh orange
 * - 2 representing a rotten orange
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 * APPROACH: BFS (Breadth-First Search) - Multi-Source BFS
 *
 * ALGORITHM (Pseudocode):
 * Phase 1: Initialization
 * 1. Count total fresh oranges
 * 2. Add all initially rotten oranges to queue
 * 3. If no fresh oranges exist, return 0
 *
 * Phase 2: BFS - Spread the Rot
 * 4. While queue is not empty:
 *    a. Get current queue size (all oranges rotten at this minute)
 *    b. For each rotten orange in current level:
 *       - Poll from queue
 *       - Check all 4 directions (up, down, left, right)
 *       - If neighbor is fresh (== 1):
 *         * Mark it as rotten (change to 2)
 *         * Decrease fresh count
 *         * Add to queue
 *    c. Increment minutes after processing all oranges at current level
 *
 * Phase 3: Check Result
 * 5. If fresh oranges remain, return -1 (impossible)
 * 6. Otherwise, return minutes - 1 (adjust for extra increment)
 *
 * KEY INSIGHT:
 * - BFS ensures we process oranges level by level (minute by minute)
 * - Multi-source BFS: Start from ALL rotten oranges simultaneously
 * - Queue size per level = all oranges that rot in the same minute
 *
 * WHY BFS (not DFS)?
 * - Need to track TIME (minutes)
 * - BFS processes layer by layer = time progression
 * - DFS would go deep first, not suitable for time-based spreading
 *
 * TIME COMPLEXITY: O(M × N) where M = rows, N = columns
 *                  - Visit each cell at most once
 *                  - Each cell is added to queue at most once
 *
 * SPACE COMPLEXITY: O(M × N)
 *                   - Queue can hold up to M×N cells in worst case
 *                   - No extra space for visited array (modify grid in-place)
 */

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        // Edge case
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        // Phase 1: Count fresh oranges and enqueue rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;  // Count fresh oranges
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});  // Start BFS from all rotten
                }
            }
        }

        // If no fresh oranges, no time needed
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 4-directional

        // Phase 2: BFS - Spread the rot level by level
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();  // Number of oranges rotten at this minute

            // Process all oranges at current level (current minute)
            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();

                // Check all 4 neighbors
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    // If neighbor is fresh, make it rotten
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;  // Turn fresh orange to rotten
                        freshCount--;    // Decrease fresh count
                        rottenQueue.offer(new int[]{x, y});  // Add to queue
                    }
                }
            }

            minutes++;  // Increment timer after each level of BFS
        }

        // Phase 3: Check if all fresh oranges became rotten
        return freshCount == 0 ? minutes - 1 : -1;  // Adjust for extra increment
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();

        // Test Case 1: Normal case
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test 1 - Minutes: " + solution.orangesRotting(grid1));
        // Expected: 4

        // Test Case 2: Impossible case
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("Test 2 - Minutes: " + solution.orangesRotting(grid2));
        // Expected: -1 (bottom-left orange cannot be reached)

        // Test Case 3: No fresh oranges
        int[][] grid3 = {
                {0, 2}
        };
        System.out.println("Test 3 - Minutes: " + solution.orangesRotting(grid3));
        // Expected: 0

        // Test Case 4: Single fresh orange isolated
        int[][] grid4 = {
                {1}
        };
        System.out.println("Test 4 - Minutes: " + solution.orangesRotting(grid4));
        // Expected: -1
    }
}
/*

        ---

        ## **🎯 Visual Walkthrough**

        **Initial Grid:**
        ```
        2  1  1
        1  1  0
        0  1  1
        ```

        **Minute 0** (Start):
        - Queue: `[(0,0)]` (initial rotten)
        - Fresh count: 6

        **Minute 1**:
        ```
        2  2  1     ← (0,1) turns rotten
2  1  0     ← (1,0) turns rotten
0  1  1
        ```
        - Queue: `[(0,1), (1,0)]`
        - Fresh count: 4

        **Minute 2**:
        ```
        2  2  2     ← (0,2) turns rotten
2  2  0     ← (1,1) turns rotten
0  1  1
        ```
        - Queue: `[(0,2), (1,1)]`
        - Fresh count: 2

        **Minute 3**:
        ```
        2  2  2
        2  2  0
        0  2  1     ← (2,1) turns rotten
```
        - Queue: `[(2,1)]`
        - Fresh count: 1

        **Minute 4**:
        ```
        2  2  2
        2  2  0
        0  2  2     ← (2,2) turns rotten

 */