package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        /**
         * merge interval
         */
        int newStart = newInterval[0], newEnd = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newEnd){
            newStart= Math.min(newStart, intervals[i][0]);
            newEnd= Math.max(newEnd, intervals[i][1]);
            i++;
        }

        result.add(new int[]{newStart, newEnd});
        while (i< intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {

    }

}
