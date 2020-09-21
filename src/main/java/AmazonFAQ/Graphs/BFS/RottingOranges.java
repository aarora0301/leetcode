package main.java.AmazonFAQ.Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**********
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible,
 * return -1 instead.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                for (int[] d : directions) {
                    int neighbourRow = top[0] + d[0];
                    int neighbourCol = top[1] + d[1];
                    if (neighbourRow < 0 || neighbourRow >= grid.length || neighbourCol < 0 || neighbourCol >= grid[0].length
                            || grid[neighbourRow][neighbourCol] == 0 || grid[neighbourRow][neighbourCol] == 2) {
                        continue;
                    }

                    grid[neighbourRow][neighbourCol] = 2;
                    queue.offer(new int[]{neighbourRow, neighbourCol});
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? count - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 2}};
        RottingOranges oranges = new RottingOranges();
        System.out.println(oranges.orangesRotting(grid));
    }
}
