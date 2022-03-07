package Patterns.TwoHeaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/find-right-interval/solution/
 *  https://just4once.gitbooks.io/leetcode-notes/content/leetcode/binary-search/436-find-right-interval.html
 */
public class RightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int[][] endIntervals = Arrays.copyOf(intervals, intervals.length);
        HashMap<int[], Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(endIntervals, (a, b) -> a[1] - b[1]);
        int j = 0;
        int[] res = new int[intervals.length];
        for (int i = 0; i < endIntervals.length; i++) {
            while (j < intervals.length && intervals[j][0] < endIntervals[i][1]) {
                j++;
            }
            res[hash.get(endIntervals[i])] = j == intervals.length ? -1 : hash.get(intervals[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 13}, {13, 15}, {6, 9}};
        RightInterval rightInterval = new RightInterval();
        int[] ans= rightInterval.findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
}
