package Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#
 */
public class RemoveDuplicates1 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            start = i;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            if (start + 1 >= nums.length && i + 1 >= nums.length) {
                continue;
            }
            nums[start + 1] = nums[i + 1];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(num));
    }
}
