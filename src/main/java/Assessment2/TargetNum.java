package Assessment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetNum {

    public static void main(String[] args) {
        TargetNum targetNum = new TargetNum();
        System.out.println(Arrays.toString(targetNum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(targetNum.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(targetNum.twoSum(new int[]{3, 3}, 6)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
