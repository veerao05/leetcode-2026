package ds.graphs;

/**
 * FLOOD FILL ALGORITHM
 * =====================
 * Problem: Paint all connected pixels of the same color starting from a given position
 * Similar to: Paint bucket tool in image editors
 *
 * LeetCode Problem: https://leetcode.com/problems/flood-fill/
 * Problem Number: 733
 * Difficulty: Easy
 *
 * PSEUDOCODE:
 * -----------
 * function floodFill(image, sr, sc, newColor):
 *     originalColor = image[sr][sc]
 *
 *     // Optimization: if already the target color, no work needed
 *     if originalColor == newColor:
 *         return image
 *
 *     // Start the recursive fill
 *     helper(image, sr, sc, originalColor, newColor)
 *     return image
 *
 * function helper(image, i, j, originalColor, newColor):
 *     // Base cases - stop recursion when:
 *     // 1. Out of bounds (top, bottom, left, or right edge)
 *     // 2. Current pixel doesn't match original color (barrier or already visited)
 *     if i < 0 OR i >= rows OR j < 0 OR j >= cols OR image[i][j] != originalColor:
 *         return
 *
 *     // Paint current pixel
 *     image[i][j] = newColor
 *
 *     // Recursively paint all 4 neighbors (DFS - Depth First Search)
 *     helper(image, i-1, j, originalColor, newColor)  // UP
 *     helper(image, i+1, j, originalColor, newColor)  // DOWN
 *     helper(image, i, j-1, originalColor, newColor)  // LEFT
 *     helper(image, i, j+1, originalColor, newColor)  // RIGHT
 *
 * TIME COMPLEXITY:
 * ----------------
 * O(N * M) where N = number of rows, M = number of columns
 *
 * Explanation:
 * - In the worst case, we visit every single pixel in the image exactly once
 * - Example worst case: entire image is the same color
 *   Image: [[1,1,1], [1,1,1], [1,1,1]] → all 9 pixels visited
 * - Each pixel is painted once and never revisited (because painted pixels
 *   don't match originalColor anymore)
 *
 * SPACE COMPLEXITY:
 * -----------------
 * O(N * M) for the recursion call stack
 *
 * Explanation:
 * - Each recursive call adds a frame to the call stack
 * - In the worst case, the recursion depth equals the number of pixels
 * - Example worst case: long snake of connected pixels
 *   Image: [[1,1,1,1,1,1,1,1,1,1]] → recursion depth = 10
 * - The call stack grows until we hit a base case, then unwinds
 * - If image is N×M and all same color, stack depth could be up to N*M
 *
 * ALGORITHM TYPE:
 * ---------------
 * - Graph Traversal using Depth First Search (DFS)
 * - Recursive implementation
 * - In-place modification (modifies original image array)
 *
 * KEY INSIGHTS:
 * -------------
 * 1. Painting a pixel with newColor marks it as "visited"
 * 2. The condition image[i][j] != color prevents:
 *    a) Painting different colored pixels (barriers)
 *    b) Revisiting already painted pixels (infinite loop prevention)
 * 3. The check (newColor != color) at start prevents unnecessary work
 *    and infinite recursion if source is already target color
 *
 * TRACE EXAMPLE:
 * --------------
 * Input: image = [[1,1,1], [1,1,0], [1,0,1]], sr=1, sc=1, newColor=2
 *
 * Step 1: Start at (1,1), color=1
 * [1, 1, 1]
 * [1, 1, 0]
 * [1, 0, 1]
 *
 * Step 2: Paint (1,1)=2, recurse to neighbors
 * [1, 1, 1]
 * [1, 2, 0]  ← painted
 * [1, 0, 1]
 *
 * Step 3: Spread to all connected 1s
 * [2, 2, 2]  ← all connected 1s become 2
 * [2, 2, 0]  ← 0 acts as barrier
 * [2, 0, 1]  ← isolated 1 remains (not connected)
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1; // starting row
        int sc = 1; // starting column
        int newColor = 2;

        System.out.println("Original Image:");
        printImage(image);

        floodFill(image, sr, sc, newColor);

        System.out.println("\nAfter Flood Fill:");
        printImage(image);

        System.out.println("\nExpected Output:");
        System.out.println("2 2 2");
        System.out.println("2 2 0");
        System.out.println("2 0 1");
    }

    /**
     * Main flood fill function
     * @param image - 2D array representing the image
     * @param sr - starting row coordinate
     * @param sc - starting column coordinate
     * @param newColor - color to fill with
     * @return modified image
     */
    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Get the original color at starting position
        int color = image[sr][sc];

        // Optimization: only fill if the new color is different
        // This prevents infinite recursion when source already has target color
        if(newColor != color) {
            helper(image, sr, sc, color, newColor);
        }
        return image;
    }

    /**
     * Recursive helper function that performs DFS to paint connected pixels
     * @param image - the image array
     * @param i - current row
     * @param j - current column
     * @param color - original color we're looking for
     * @param newColor - new color to paint with
     */
    private static void helper(int[][] image, int i, int j, int color, int newColor) {
        // Base cases - stop recursion when:
        // 1. Out of bounds (row or column)
        // 2. Current pixel is not the original color (either barrier or already visited)
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
            return;
        }

        // Paint current pixel with new color (marks as visited)
        image[i][j] = newColor;

        // Recursively paint all 4 adjacent neighbors (DFS)
        helper(image, i-1, j, color, newColor);  // UP
        helper(image, i+1, j, color, newColor);  // DOWN
        helper(image, i, j-1, color, newColor);  // LEFT
        helper(image, i, j+1, color, newColor);  // RIGHT
    }

    /**
     * Utility method to print the image
     */
    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}

/*
 * COMPLEXITY SUMMARY:
 * ===================
 * Time Complexity: O(N × M)
 *   - N = number of rows
 *   - M = number of columns
 *   - Each pixel visited at most once
 *
 * Space Complexity: O(N × M)
 *   - Recursion call stack in worst case
 *   - Worst case: all pixels connected in a line
 *
 * RELATED PROBLEMS:
 * =================
 * - Number of Islands (LeetCode 200)
 * - Surrounded Regions (LeetCode 130)
 * - Pacific Atlantic Water Flow (LeetCode 417)
 * - Max Area of Island (LeetCode 695)
 */