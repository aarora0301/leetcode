package main.java.Arrays;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class _1299 {
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1};
        }
        int len = arr.length;
        int[] result = new int[len];

        result[len - 1] = -1;
        if (len == 1) {
            return result;
        }
        result[len - 2] = arr[len - 1];
        if (len == 2) {
            return result;
        }
        int index = len - 3;
        while (index >= 0) {
            if (arr[index + 1] > result[index + 1]) {
                result[index] = arr[index + 1];
            } else result[index] = result[index + 1];

            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        _1299 test = new _1299();
        int[] arr = {17, 18, 5, 4, 6, 1};
        Arrays.stream(test.replaceElements(arr)).forEach(System.out::println);
    }
}
