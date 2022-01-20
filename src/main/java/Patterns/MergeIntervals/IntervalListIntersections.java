import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0, low = 0, high = 0;

        while (i < firstList.length && j < secondList.length) {

            low = Math.max(firstList[i][0], secondList[j][0]);
            if (firstList[i][1] < secondList[j][1]) {
                high = firstList[i][1];
                i++;
            } else {
                high = secondList[j][1];
                j++;
            }
            if (low <= high) {
                list.add(new int[]{low, high});
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        IntervalListIntersections temp = new IntervalListIntersections();
        int[][] ans = temp.intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(ans));
    }
}
