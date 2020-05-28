package main.java.May_LeetCodingChallenge.Week4;

import java.util.Arrays;

/*****
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in
 * their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n)
 * /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] cache = new int[num + 1];
        cache[0] = 0;

        for (int temp = 1; temp <= num; temp++) {
            if (isPowerOfTwo(temp + 1)) {
                cache[temp] = getBits(temp + 1);
            } else if (isEven(temp)) {
                cache[temp] = cache[temp / 2];
            } else {
                cache[temp] = 1 + cache[temp - 1];
            }
        }
        return cache;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private boolean isPowerOfTwo(int num) {
        return ((num) & (num - 1)) == 0;
    }

    private int getBits(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    /**
     * Simple solution
     *
     * @param num
     * @return
     */
    public int[] _countBits(int num) {
        int[] n = new int[num + 1];

        for (int i = 1; i < n.length; i++)
            n[i] = (i % 2 == 1) ? n[i - 1] + 1 : n[i / 2];

        return n;
    }

    public static void main(String[] args) {
        CountingBits test = new CountingBits();
        int[] result = test.countBits(5);
        Arrays.toString(result);
    }

}