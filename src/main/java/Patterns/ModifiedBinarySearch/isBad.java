package Patterns.ModifiedBinarySearch;

/***
 * https://leetcode.com/problems/first-bad-version
 */
public class isBad {

    public int firstBadVersion(int n) {
        int start = 1, mid = 0, end = n;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;

    }

    private boolean isBadVersion(int n) {
        return Boolean.TRUE;
    }

}
