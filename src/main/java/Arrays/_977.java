package main.java.Arrays;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted
 * non-decreasing order.
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class _977 {

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        int index = A.length - 1;
        while (start <= end) {
            if (A[start] * A[start] > A[end] * A[end]) {
                result[index--] = A[start] * A[start];
                start++;
            } else {
                result[index--] = A[end] * A[end];
                end--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        _977 test = new _977();
        int[] A = {-7, -3, 2, 3, 11};
        Arrays.stream(test.sortedSquares(A)).forEach(System.out::println);
    }
}
