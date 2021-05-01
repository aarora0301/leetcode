package main.java.Arrays;

import java.util.Arrays;

/***
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 * Example 1:
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 *
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */

public class _769 {

    public static void main(String[] args) {
        _769 test = new _769();
        int res = test.maxChunksToSorted(new int[]{1, 2, 3, 4, 5});
        System.out.println(res);
    }

    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int maxPre[] = new int[len];
        int minSuf[] = new int[len];


        if (len == 0) return 0;

        maxPre[0] = arr[0];
        minSuf[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            maxPre[i] = Math.max(maxPre[i - 1], arr[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            minSuf[i] = Math.min(minSuf[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (maxPre[i] <= minSuf[i + 1]) {
                ans++;
            }
        }

        return ans + 1;
    }
}
