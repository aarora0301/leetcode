package main.java.AmazonFAQ.DFS.IslandVariants;

/***********
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed
 * island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 */
public class ClosedIslands {

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        ClosedIslands ci = new ClosedIslands();
        System.out.println(ci.closedIsland(grid));
    }
}
