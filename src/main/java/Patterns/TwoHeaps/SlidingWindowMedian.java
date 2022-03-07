package Patterns.TwoHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/sliding-window-median/
 * https://wxx5433.gitbooks.io/interview-preparation/content/part_ii_leetcode_lintcode/heap/sliding_window_median.html
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        double[] result = new double[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            addNum(maxHeap, minHeap, nums[i]);
            balanceHeap(maxHeap, minHeap);
        }
        result[index++] = findMedian(maxHeap, minHeap);

        for (int i = k; i < nums.length; i++) {
            addNum(maxHeap, minHeap, nums[i]);
            slideWindow(maxHeap, minHeap, nums[i - k]);
            balanceHeap(maxHeap, minHeap);
            result[index++] = findMedian(maxHeap, minHeap);
        }
        return result;
    }

    private void slideWindow(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        if (maxHeap.peek() >= num) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }

    private void addNum(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
    }

    private void balanceHeap(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);
        }
        return (double) maxHeap.peek();
    }


    public static void main(String[] args) {
        SlidingWindowMedian sl = new SlidingWindowMedian();
        double[] result;
        result = sl.medianSlidingWindow(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2);
        System.out.println(Arrays.toString(result));
    }

}
