package main.java.Medium;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;
        /**
         * Perform transpose
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /**
         * Swap columns
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - j - 1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        RotateImage test = new RotateImage();
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        test.rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
