package main.java.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given a m * n matrix mat of integers, sort it diagonally in ascending order from
the top-left to the bottom-right then return the sorted array.
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 */
public class _1329 {

    public int[][] diagonalSort(int[][] mat) {
        /**
         * sort first half of matrix
         */
        for (int i = 0; i < mat.length; i++) {
            sortOneDiagonal(mat, i, 0);
        }
        /**
         * sort second half of matrix
         */
        for (int j = 1; j < mat[0].length; j++) {
            sortOneDiagonal(mat, 0, j);
        }
        return mat;
    }

    private void sortOneDiagonal(int[][] mat, int row, int col) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = row, j = col; i < mat.length && j < mat[0].length; i++, j++) {
            pq.add(mat[i][j]);
        }
        for (int i = row, j = col; i < mat.length && j < mat[0].length; i++, j++) {
            mat[i][j] = pq.poll();
        }
    }


    public static void main(String[] args) {
        _1329 test = new _1329();
        int[][] mat = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        Arrays.stream(test.diagonalSort(mat))
                .map(row -> IntStream.of(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
