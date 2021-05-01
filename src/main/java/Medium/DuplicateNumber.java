package main.java.Medium;

/***
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 */
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int index = 0;
        for (int num : nums) {
            index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                return index + 1;
            } else nums[index] = nums[index] * -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicateNumber test = new DuplicateNumber();
        System.out.println(test.findDuplicate(new int[]{2, 2, 2, 2, 2}));
    }
}
