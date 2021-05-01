package main.java.FAQ;


import java.util.Arrays;

/*****
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains
 * a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int rem = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (rem + digits[i] > 9) {
                digits[i] = (rem + digits[i]) % 10;
                rem = 1;
            } else {
                digits[i] = rem + digits[i];
                rem = 0;
            }
        }
        if (rem != 0) {
            int[] temp = new int[digits.length + 1];
            temp[0] = rem;
            for (int i = 0; i < digits.length; i++) {
                temp[i + 1] = digits[i];
            }
            return temp;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}
