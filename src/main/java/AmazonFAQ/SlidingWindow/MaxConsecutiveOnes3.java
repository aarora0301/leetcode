package main.java.AmazonFAQ.SlidingWindow;

public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] A, int K) {
        int count = 0, res = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count++;
            }
            while (count > K && j < A.length) {
                if (A[j] == 0) {
                    count--;
                }
                j++;
            }

            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
