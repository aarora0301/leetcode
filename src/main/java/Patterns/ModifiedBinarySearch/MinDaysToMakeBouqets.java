package Patterns.ModifiedBinarySearch;


/****
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * https://www.youtube.com/watch?v=paYIrQKxE7I
 */
public class MinDaysToMakeBouqets {

    public static void main(String[] args) {
        MinDaysToMakeBouqets minDaysToMakeBouqets = new MinDaysToMakeBouqets();
        System.out.println(minDaysToMakeBouqets.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));

    }

    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length == 0 || m == 0 || k == 0) {
            return 0;
        }
        if (m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(m, bloomDay, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
         return left;

    }

    boolean isValid(int m, int[] bloomDay, int k, int mid) {
        int size = 0, count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            size = bloomDay[i] <= mid ? size + 1 : 0;
            if (size == k) {
                size = 0;
                count++;
            }
            if (count == m) {
                return true;
            }
        }
        return false;
    }


}
