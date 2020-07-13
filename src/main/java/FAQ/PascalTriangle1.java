package main.java.FAQ;


import java.util.ArrayList;
import java.util.List;

/****
 * iven a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle1 {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            temp.add(0, 1);

            for (int j = 1; j < temp.size() - 1; j++) {
                temp.set(j, temp.get(j) + temp.get(j + 1));
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
