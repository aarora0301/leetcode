package Patterns.ModifiedBinarySearch;

/****
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 */
public class ShipPackages {

    public int shipWithinDays(int[] weights, int days) {

        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            left = Math.min(left, weights[i]);
            right += weights[i];
        }
        int mid = 0, result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (isValid(weights, days, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }

    boolean isValid(int[] weights, int days, int mid) {
        int size = 0, count = 1, i = 0;
        for (i = 0; i < weights.length; i++) {
            if (weights[i] > mid) {
                return false;
            }

            if (size + weights[i] <= mid) {
                size += weights[i];
            } else {
                size = weights[i];
                count++;
                if (count > days) {
                    return false;
                }
            }

        }

        return true;

    }

    public static void main(String[] args) {
        ShipPackages shipPackages = new ShipPackages();
        System.out.println(shipPackages.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));

    }

}
