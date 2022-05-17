package Patterns.TreeBFS;

import java.util.Arrays;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    backTrack(grid, i, j);
                    count = count + 1;
                }
            }
        }
        return count;

    }

    private void backTrack(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        backTrack(grid, i - 1, j);
        backTrack(grid, i + 1, j);
        backTrack(grid, i, j - 1);
        backTrack(grid, i, j + 1);
    }

    public static void main(String[] args) {
        NumberOfIslands number = new NumberOfIslands();
        char[][] grid = {{'1'}, {'1'}};
        System.out.println(number.numIslands(grid));
        System.out.println(Arrays.deepToString(grid));
    }
}
