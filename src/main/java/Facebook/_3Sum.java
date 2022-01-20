package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        for (int i = 0; i < nums.length - 2; i++) {

            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(arr));
    }

}
