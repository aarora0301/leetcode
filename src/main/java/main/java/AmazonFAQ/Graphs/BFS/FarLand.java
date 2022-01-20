package main.java.AmazonFAQ.Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

/****
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such
 * that its distance to the nearest land cell is maximized and return the distance.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is
 * |x0 - x1| + |y0 - y1|.
 *
 * If no land or water exists in the grid, return -1.
 *
 *
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 */
public class FarLand {

    public static int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else {
                    grid[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int[] d : directions) {
                int neighbourRow = top[0] + d[0];
                int neighbourCol = top[1] + d[1];
                if (neighbourRow < 0 || neighbourRow >= row || neighbourCol < 0 || neighbourCol >= col) {
                    continue;
                }
                if (grid[neighbourRow][neighbourCol] == Integer.MIN_VALUE) {
                    grid[neighbourRow][neighbourCol] = grid[top[0]][top[1]] + 1;
                    result = Math.max(result, grid[neighbourRow][neighbourCol] - 1);
                    queue.offer(new int[]{neighbourRow, neighbourCol});
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
