package main.java._30DayLeetcoding;

import java.util.List;

/***
 * (This problem is an interactive problem.)
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted
 * in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
 * If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions
 * that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples.
 * You will not have access the binary matrix directly.
 *
 *  Input: mat = [[0,0],[1,1]]
 * Output: 0
 *
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 */


interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

public class LeftMostColumn {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row = list.get(0);
        int col = list.get(1);
        int i = 0, j = col - 1, leftMostOne = -1;
        while (i < row && j >= 0) {
            int resut = binaryMatrix.get(i, j);
            if (resut == 0) {
                i++;
            } else {
                leftMostOne = j;
                j--;
            }
        }
        return leftMostOne;
    }
}
