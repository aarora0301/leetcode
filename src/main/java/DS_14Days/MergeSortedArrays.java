package DS_14Days;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1, p1 = m - 1, p2 = n - 1;
        while (p > -1) {
            int num1 = p1 > -1 ? nums1[p1]: Integer.MIN_VALUE;
            int num2 = p2 > -1 ? nums2[p2] : Integer.MIN_VALUE;
            if (num1 > num2) {
                nums1[p] = num1;
                p1--;
            } else {
                nums1[p] = num2;
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        merge(arr, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(arr));
    }

}
