package main.java.May_LeetCodingChallenge.Week3;

import java.rmi.MarshalException;
import java.util.Arrays;

/***
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty
 * subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the array.
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a
 * subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j
 * with k1 % A.length = k2 % A.length.)
 *
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 *  There will be two cases :
 *  1. max subarray is not circular subarray ex: 1,-2,3, 4,-2 --> max= 7
 *     a. for approach 1 we can follow kadane algorithm
 *  2. max subarray is circular subarray ex: 5,-1,5 ---> max= 10
 *     a. for finding max in split across/circular array we find max sum by finding total sum - minSum
 *     b. case 2 can have one corner case, when all numbers are negative ex: -2,-3,-1
 *      with above approach max will be zero as min always = total sum but max should be -1 for above case.
 *     c. add a check wif max < 0 (means all number are negative) return max otherwise
 *        return max(maxFromApproach1, maxFromApproach2) where maxApproach2= totalSum- minSum
 */
public class MaximumSumCircularSubArray {

    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, currMax = 0, currMin = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            currMax = Math.max(currMax + A[i], A[i]);
            max = Math.max(currMax, max);

            currMin = Math.min(currMin + A[i], A[i]);
            min = Math.min(min, currMin);
            total += A[i];
        }
        return max < 0 ? max : Math.max(max, total - min);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubArray test = new MaximumSumCircularSubArray();
        System.out.println(test.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
