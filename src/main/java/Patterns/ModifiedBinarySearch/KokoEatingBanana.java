package Patterns.ModifiedBinarySearch;

/***
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int mid = 0;
        int result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isValid(piles, mid, h)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }

    private boolean isValid(int[] piles, int mid, int h) {
        int countHour = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] <= mid) {
                countHour += 1;
            } else {
                int mod = piles[i] % mid;
                countHour += piles[i] / mid;
                if (mod > 0) {
                    countHour++;
                }
                if (countHour > h) {
                    return false;
                }

            }
        }
        return countHour <= h;
    }

    public static void main(String[] args) {

        KokoEatingBanana kokoEatingBanana = new KokoEatingBanana();
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{312884470}, 312884469));
        // System.out.println(kokoEatingBanana.isValid(new int[]{30, 11, 23, 4, 20}, 30, 5));

    }
}
