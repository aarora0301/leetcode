package main.java.Arrays;

/*
Given an array of integers, find out whether there are two distinct
indices i and j in the array such that the absolute difference
between nums[i] and nums[j] is at most t and the absolute difference
between i and j is at most k.
 */
public class _220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 1;
            while (count <= k) {
                if (i + count < nums.length && Math.abs((long)nums[i] - (long)nums[i + count]) <= t) {
                    return true;
                }
                count++;
            }
        }
        return false;
    }

    private long abs(long x) {
        if (x >= 0) {
            return x;
        }
        return (-x);
    }

    public static void main(String[] args) {
        _220 test = new _220();
        int[] nums = {2147483647,-2147483647};
        int k = 1, t = 2147483647;
        System.out.println(test.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
