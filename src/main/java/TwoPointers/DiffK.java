package main.java.TwoPointers;

import java.util.Arrays;

public class DiffK {

    public static int diffPossible(int[] A, int B) {
        int left = 0;
        int right = A.length - 1;
        int temp;
        while (left < right) {
            temp = (A[right] - A[left]);
            if (temp == B) {
                return 1;
            } else if (temp < B) {
                left++;
            } else {
                right--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4};
        int B = 0;
        int ans = diffPossible(arr, B);
        System.out.println(ans);
    }
}
