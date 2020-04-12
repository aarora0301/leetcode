package main.java.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = len - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArray test = new ProductOfArray();
        int[] result = test.productExceptSelf(new int[]{1, 2, 3, 4});
        Arrays.stream(result).forEach(System.out::println);
    }
}
