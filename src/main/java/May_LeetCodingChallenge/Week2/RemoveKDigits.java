package main.java.May_LeetCodingChallenge.Week2;

import java.util.Stack;

/***
 * Given a non-negative integer num represented as a string, remove k
 * digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number
 * 1219 which is the smallest.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (k >= 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        /**
         *  Case : when incoming elements are in increasing order
         */
        while (k >= 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        /**
         * store remaining  characters after removing 'k' characters
         */
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        /**
         * since we are retrieving data from stack its fetched in reverse
         * order i.e from len-1 to 0 so we have to reverse the data
         * retrieved from stack
         */
        result = result.reverse();
        int i = 0;
        /**
         * Remove leading leading zeroes
         */
        while (result.length() > 1 && result.charAt(i) == '0') {
            result.deleteCharAt(i);
        }
        return result.toString();
    }
}
