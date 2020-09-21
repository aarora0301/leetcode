package main.java.AmazonFAQ.Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

/****
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 *  Hint: Rather then getting 0 around 1,
 *  get 1's around 0 i.e capture all 0 cells , then start moving around and keep updating non zeroed cells
 */

public class _01_Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{{}};
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int[] d : directions) {
                int neighbourRow = top[0] + d[0];
                int neighbourCol = top[1] + d[1];
                if (neighbourRow < 0 || neighbourRow >= matrix.length || neighbourCol < 0 || neighbourCol >= matrix[0].length) {
                    continue;
                }
                if (matrix[neighbourRow][neighbourCol] == Integer.MAX_VALUE) {
                    matrix[neighbourRow][neighbourCol] = matrix[top[0]][top[1]] + 1;
                    queue.offer(new int[]{neighbourRow, neighbourCol});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}
