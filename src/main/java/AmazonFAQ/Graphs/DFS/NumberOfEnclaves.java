package main.java.AmazonFAQ.Graphs.DFS;


/*****
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 *
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 *
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 *
 * Example 2:
 *
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:
 * All 1s are either on the boundary or can reach the boundary.
 */
public class NumberOfEnclaves {

    public int numEnclaves(int[][] A) {

        int ans = 0;
        if (A == null || A.length == 0) {
            return ans;
        }

        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i==0 || j==0 || i== row-1 || j== col-1)
                dfs(A, i, j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] A, int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] != 1) {
            return;
        }
        A[row][col] = -1;
        dfs(A, row + 1, col);
        dfs(A, row - 1, col);
        dfs(A, row, col - 1);
        dfs(A, row, col + 1);
    }
}
