package main.java._30DayLeetcoding;

/****
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 *
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Solution using DFS
 * Response : Time Limit Exceeded
 */

public class MinimumPathSum {

    int result = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int sum = grid[rowLen - 1][colLen - 1];
        int currRow = 0, currCol = 0;
        dfs(sum, currCol, currRow, rowLen, colLen, grid);
        return result;
    }

    private void dfs(int sum, int currCol, int currRow, int rowLen, int colLen, int[][] grid) {
        if (currRow >= rowLen || currCol >= colLen) {
            return;
        }
        if (currRow == rowLen - 1 && currCol == colLen - 1) {
            result = Math.min(result, sum);
            return;
        }
        dfs(sum + grid[currRow][currCol], currCol + 1, currRow, rowLen, colLen, grid);
        dfs(sum + grid[currRow][currCol], currCol, currRow + 1, rowLen, colLen, grid);
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        System.out.println(test.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
