import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;


public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] result = _maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        System.out.println(Arrays.toString(result));
    }

    /****
     * Using Heaps
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) {
            q.add(new int[]{nums[i], i});
        }

        int cur = k;
        int index = 1;
        int[] ans = new int[nums.length - k + 1];
        ans[0] = q.peek()[0];

        while (cur < nums.length) {

            // remove out of window elements
            while (!q.isEmpty() && (q.peek()[1] < cur - k + 1)) {
                q.remove();
            }

            q.add(new int[]{nums[cur], cur});
            ans[index++] = q.peek()[0];
            cur++;
        }

        return ans;
    }

    /***
     * Using Deque
     * https://afteracademy.com/blog/sliding-window-maximum
     * @param nums
     * @param k
     * @return
     */
    public static int[] _maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        ans[index++] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
            ans[index++] = nums[deque.getFirst()];
        }
        return ans;
    }

}
