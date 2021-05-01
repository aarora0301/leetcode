package main.java.AmazonFAQ.stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingMaximumWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.removeLast();
            deque.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingMaximumWindow test = new SlidingMaximumWindow();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
