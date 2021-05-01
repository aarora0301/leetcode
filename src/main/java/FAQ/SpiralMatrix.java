package main.java.FAQ;

import java.util.ArrayList;
import java.util.List;

/***
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length==0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        /**
         *  assign lower and upper limit for row
         */
        int top = 0, bottom = matrix.length - 1;
        /**
         *  assign lower and upper limit for col
         */
        int left = 0, right = matrix[0].length >= 1 ? matrix[0].length - 1 : 0;


        while (true) {

            if (left > right) {
                return result;
            }

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            if (top > bottom) {
                return result;
            }
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left > right) {
                return result;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            if (top > bottom) {
                return result;
            }

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

    }


    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        System.out.println(test.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
