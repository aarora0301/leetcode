package main.java.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over
 * it's main diagonal, switching the row and column indices
 * of the matrix.
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 */
public class _867 {
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;

    }

    private void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void main(String[] args) {
        _867 test = new _867();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        //     test.transpose(arr);
        Arrays.stream(test.transpose(arr))
                .map(row -> IntStream.of(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
