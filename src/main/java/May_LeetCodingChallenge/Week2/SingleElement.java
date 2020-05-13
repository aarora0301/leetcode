package main.java.May_LeetCodingChallenge.Week2;

/***
 * You are given a sorted array consisting of only integers where every
 * element appears exactly twice, except for one element which appears
 * exactly once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 */
public class SingleElement {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;

        if (len == 1) {
            return nums[0];
        }

        while (left <= right) {
            if (left + 1 < len && nums[left] == nums[left + 1]) {
                left = left + 2;
            } else if (left + 1 < len && nums[left] != nums[left + 1]) {
                return nums[left];
            }

            if (right - 1 >= 0 && nums[right] == nums[right - 1]) {
                right = right - 2;
            } else if (right - 1 >= 0 && nums[right] != nums[right - 1]) {
                return nums[right];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        SingleElement test = new SingleElement();
        System.out.println(test.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
}
