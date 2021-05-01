package main.java.May_LeetCodingChallenge.Week1;


import main.java._30DayLeetcoding.FirstUnique;

import java.util.Arrays;

/****
 * iven a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        int result = -1;
        int count[] = new int[26];
        int index[] = new int[26];
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            ind =  s.charAt(i) - 'a';
            count[ind]++;
            index[ind] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            ind =  s.charAt(i) - 'a';
            if (count[ind] == 1) {
                result = index[ind];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter test= new FirstUniqueCharacter();
        System.out.println(test.firstUniqChar("leetcode"));
    }
}
