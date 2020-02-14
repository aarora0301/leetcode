package main.java.Arrays;

/**
 * Given an array of integers and an integer k, find out whether
 * there are two distinct indices i and j in the array such that
 * nums[i] = nums[j] and the absolute difference between i and j
 * is at most k.
 */
public class _219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 1;
            while (count <= k) {
                if (i + count < nums.length && nums[i] == nums[i + count]) {
                    return true;
                }
                count++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {99, 99};
        int k = 2;
        _219 test = new _219();
        System.out.println(test.containsNearbyDuplicate(nums, k));
    }
}
