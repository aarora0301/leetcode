import java.lang.reflect.Array;
import java.util.Arrays;

/***
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int currEnd = intervals[0][1], nextStart = 0, nextEnd = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            nextStart = intervals[i][0];
            nextEnd = intervals[i][1];

            if (currEnd > nextStart) {
                count += 1;
                currEnd = Math.min(currEnd, nextEnd);
            } else {
                currEnd = nextEnd;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
