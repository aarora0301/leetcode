package main.java.Arrays;

import javax.swing.plaf.metal.MetalTheme;

/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
 * <p>
 * You can move according to the next rules:
 * <p>
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 * <p>
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * <p>
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 */
public class _1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0] - points[i - 1][0];
            int y = points[i][1] - points[i - 1][1];
            result += Math.max(Math.abs(x), Math.abs(y));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 2}, {-2, 2}};
        _1266 test = new _1266();
        System.out.println(test.minTimeToVisitAllPoints(points));
        //test.minTimeToVisitAllPoints(points);
    }
}
