package Leetcode.Arrays;

/**
 * 1252: https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * <p>
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 * <p>
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 * <p>
 * <p>
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * <p>
 * Using bit manipulation
 * <p>
 * hint: use xor operation
 */
public class CellsWithOddVal {

    public int oddCells(int n, int m, int[][] indices) {
        byte[] row = new byte[n];
        byte[] col = new byte[m];
        for (int[] i : indices) {
            row[i[0]] ^= 1;
            col[i[1]] ^= 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += row[i] ^ col[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2, m = 3;
        int[][] input = {{0, 1}, {1, 0}};
        CellsWithOddVal od = new CellsWithOddVal();
        System.out.println(od.oddCells(n, m, input));
    }
}
