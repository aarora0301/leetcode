package DS_14Days;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSoFar = Math.max(currSum, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int result = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
    }
}
