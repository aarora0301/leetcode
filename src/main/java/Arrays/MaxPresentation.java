package main.java.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPresentation {

    public int canAttendMeetings(int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));
        pq.addAll(Arrays.asList(meetings));
        int count = 0;

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int[] second = pq.peek();
            /**
             * if they overlap
             */
            if (first != null && second != null && second[0] <= first[1]) {
                continue;
            } else {
                count += 2;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {1, 2}, {2, 4}};
        System.out.println(new MaxPresentation().canAttendMeetings(arr));
    }
}
