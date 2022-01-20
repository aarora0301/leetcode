import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            priorityQueue.add(interval);
        }
        Stack<int[]> stack = new Stack<>();
        while (!priorityQueue.isEmpty()) {
            int[] currInterval = priorityQueue.poll();
            if (stack.isEmpty() || currInterval[0] > stack.peek()[1]) {
                stack.add(currInterval);
            } else {
                int[] top = stack.pop();
                stack.add(new int[]{top[0], Math.max(top[1], currInterval[1])});
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 3}, {3, 4}, {4, 5}};
        int[][] ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
        intervals = new int[][]{{1, 4}, {4, 5}};
        ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
        intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
        intervals = new int[][]{{1, 3}};
        ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));

    }
}
