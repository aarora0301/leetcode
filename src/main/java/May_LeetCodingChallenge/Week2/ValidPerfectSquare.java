package main.java.May_LeetCodingChallenge.Week2;

import main.java._30DayLeetcoding.ValidParethesis;

/***
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        long mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = (int) mid - 1;
            } else start = (int) mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(4));
    }
}

