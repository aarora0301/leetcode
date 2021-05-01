package main.java._30DayLeetcoding;

/****
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num = num + 1;
                }

                //dfs(grid, i, j);
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x > grid.length - 1 || x < 0 || y < 0 || y > grid[0].length - 1 || (grid[x][y] == '0'))
            return;
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
    }

    public static void main(String[] args) {
        NumberofIslands test = new NumberofIslands();
        System.out.println(test.numIslands(new char[][]{{'1', '1'}, {'0', '0'}}));
    }

}
