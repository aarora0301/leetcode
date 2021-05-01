package main.java.AmazonFAQ.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithKDifferentInteger {

    /***
     *  Time Limit Exceeded
     * @param A
     * @param K
     * @return
     */
    public int _subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int j ;
        for (int i = 0; i < A.length; i++) {
            j = i;
            set.clear();
            while (j < A.length && set.size() <= K) {
                set.add(A[j]);
                j++;
                if (set.size() == K) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,1,3,4};
        int K = 3;
        SubArrayWithKDifferentInteger si = new SubArrayWithKDifferentInteger();
        System.out.println(si._subarraysWithKDistinct(A, K));
    }

}
