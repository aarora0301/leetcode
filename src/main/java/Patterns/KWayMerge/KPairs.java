import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class KPairs {

    /***
     * Memory Exceeded
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums2 == null || nums1 == null || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (pq.size() < k) {
                    pq.add(new int[]{nums1[i], nums2[j]});
                } else {
                    if (pq.peek()[0] + pq.peek()[1] > nums1[i] + nums2[j]) {
                        pq.poll();
                        pq.add(new int[]{nums1[i], nums2[j]});
                    } else {
                        break;
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            int[] top = pq.poll();
            list.add(Arrays.asList(top[0], top[1]));
            k--;
        }
        return list;
    }

    public static void main(String[] args) {
        KPairs kPairs = new KPairs();
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        List<List<Integer>> list = kPairs.kSmallestPairs(num1, num2, 2);
        System.out.println(list);
    }

}
