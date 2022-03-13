package Patterns.ModifiedBinarySearch;

/***
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public int mySqrt(int x) {
        int start = 1, end = x, mid = 0;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start - 1;

    }

    public static void main(String[] args) {

    }

}
