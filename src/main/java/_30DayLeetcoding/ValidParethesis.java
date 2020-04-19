package main.java._30DayLeetcoding;

import java.util.ArrayList;
import java.util.List;

/****
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 *Explanation: https://leetcode.com/problems/valid-parenthesis-string/solution/
 *
 * 1- There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')'
 * 2- There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('
 * 3- There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'
 *
 * Algorithm: You can parse the String twice, once from left to right by replacing
 * all '*' by '(' and once from right to left by replacing all '*' by ')'.
 * For each of the 2 loops, if there's an iteration where you end up with a negative
 * count (SUM['('] - SUM[')'] < 0) then you know the parenthesis were not balanced.
 * You can return false. After these 2 checks (2 loops), you know the string is
 * balanced because you've satisfied all the 3 valid cases mentioned above
 */
public class ValidParethesis {

    public boolean checkValidString(String s) {
        int leftBalance = 0;
        for (int i = 0; i < s.length(); i++) {
            /**
             * Moving from left to right assume '*' to be replaced by '('
             */
            if ((s.charAt(i) == '(' || s.charAt(i) == '*')) {
                leftBalance++;
            } else {
                leftBalance--;
            }

            /**
             *  We know we have unbalanced parenthesis
             *   for cases like : ")("
             *   as soon as leftBalance becomes negative it means string
             *   is not balanced or ')' preceeds '('
             */
            if (leftBalance < 0) {
                return false;
            }
        }

        /**
         * We can already check if parenthesis are valid
         *
         */
        if (leftBalance == 0) return true;

        int rightBalance = 0;
        /**
         * Moving from right to left assume '*' to be replaced by ')'
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ')' || s.charAt(i) == '*')) {
                rightBalance++;
            } else {
                rightBalance--;
            }
            /***
             *  We know we have unbalanced parenthesis
             */
            if (rightBalance < 0) {
                return false;
            }
        }
        // Here we know we have never been unbalanced parsing from left to right e.g. ')('
        // We've also already substituted '*' either by '(' or by ')'
        // So we only have 3 possible scenarios here:
        // 1. We had the same amount of '(' and ')'
        // 2. We had more '(' then ')' but enough '*' to substitute
        // 3. We had more ')' then '(' but enough '*' to substitute
        return true;
    }


    public static void main(String[] args) {
        ValidParethesis test = new ValidParethesis();
        System.out.println(test.checkValidString("(*)"));
    }
}
