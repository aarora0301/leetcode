package main.java.FAQ;


import java.util.Arrays;

/***
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        int[] next = patternTable(needle);
        int m = needle.length();
        int n = haystack.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j];
            j++;
        }
        if (j == m) return i - m;
        return -1;
    }

    private int[] patternTable(String pattern) {
        if (pattern == null) {
            return new int[1];
        }
        int m = pattern.length();
        int[] next = new int[m];
        int j = -1;
        for (int i = 0; i < m; i++, j++) {
            if (i == 0) next[i] = -1;
            else if (pattern.charAt(i) != pattern.charAt(j)) next[i] = j;
            else next[i] = next[j];
            /*
              check if it is prefix in pattern
             */
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    public static void main(String[] args) {
        ImplementStrstr test = new ImplementStrstr();
        String haystack = "aaaaa", needle = "bbaab";
        System.out.println(test.strStr(haystack, needle));
    }
}
