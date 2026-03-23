package ds.graphs;

/*
 * PROBLEM: Surrounded Regions (LeetCode 130) https://leetcode.com/problems/surrounded-regions/description/
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * KEY INSIGHT: Instead of finding surrounded regions (hard), find unsurrounded regions (easy)
 * - Any 'O' on the border cannot be captured
 * - Any 'O' connected to a border 'O' cannot be captured
 * - Everything else can be captured
 *
 * APPROACH: DFS + Reverse Thinking
 *
 * ALGORITHM (Pseudocode):
 * Phase 1: Mark Protected Regions (boundary-connected 'O's)
 * 1. Iterate through all 4 borders (first/last row, first/last column)
 * 2. When you find an 'O' on the border:
 *    - Run DFS from that cell
 *    - Mark it and all connected 'O's as 'T' (temporary marker)
 *
 * Phase 2: Capture Surrounded Regions
 * 3. Iterate through entire board:
 *    - If cell == 'O' → change to 'X' (surrounded, capture it)
 *    - If cell == 'T' → change to 'O' (protected, restore it)
 *
 * DFS Helper:
 * 1. Base Case: If out of bounds OR cell is not 'O', return
 * 2. Mark current cell as 'T' (protected)
 * 3. Recursively explore 4 directions (up, down, right, left)
 *
 * WHY 'T'? Need to distinguish between:
 * - Original 'O's that should be captured
 * - Protected 'O's connected to borders
 *
 * TIME COMPLEXITY: O(M × N) where M = rows, N = columns
 *                  - First pass: O(M × N) to check borders and run DFS
 *                  - Second pass: O(M × N) to capture/restore
 *                  - Total: O(M × N)
 *
 * SPACE COMPLEXITY: O(M × N)
 *                   - Recursion stack depth can be M×N in worst case
 */

public class SuroundingRegion {

    public void findSurroundingRegion(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Phase 1: Mark boundary-connected 'O's with 'T'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if on border AND is 'O'
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Phase 2: Capture surrounded regions and revert 'T' to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Surrounded 'O' → capture
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Protected 'T' → restore
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {

        // Base Case: Out of bounds OR not 'O'
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }

        // Step 1: Mark as protected (temporary)
        board[i][j] = 'T';

        // Step 2: Explore all 4 directions
        dfs(board, i - 1, j);  // Up
        dfs(board, i + 1, j);  // Down
        dfs(board, i, j + 1);  // Right
        dfs(board, i, j - 1);  // Left
    }

    private static void printBoard(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[0].length - 1) System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        SuroundingRegion sr = new SuroundingRegion();

        System.out.println("Input:");
        printBoard(board);

        sr.findSurroundingRegion(board);

        System.out.println("\nOutput:");
        printBoard(board);

        /*
         * Expected Output:
         * X X X X
         * X X X X
         * X X X X
         * X O X X
         *
         * Explanation:
         * - Bottom-left 'O' is on border → protected
         * - Middle 'O's are surrounded → captured (became 'X')
         */
    }
}