package main.java.May_LeetCodingChallenge;

/****
 *  First Bad Version
 * Solution
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class BadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int mid = 0;
        while (left <= n) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            } else if (isBadVersion(mid) && isBadVersion(mid - 1)) {
                right = mid - 1;
            } else if (!isBadVersion(mid)) {
                left = mid + 1;
            }
        }
        return -1;
    }

    boolean isBadVersion(int version) {
        switch (version) {
            case 1: return false;
            case 2:
            case 3:
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BadVersion test = new BadVersion();
        System.out.println(test.firstBadVersion(3));
    }
}
