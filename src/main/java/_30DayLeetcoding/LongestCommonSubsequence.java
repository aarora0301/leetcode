package main.java._30DayLeetcoding;


public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
        // return longestCommonSubsequence(text1, text2, text1.length() - 1, text2.length() - 1);
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] cache = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[len1][len2];
    }

    /***
     * Time Limit Exceeded
     * @param text1
     * @param text2
     * @param len1
     * @param len2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2, int len1, int len2) {
        if (len1 < 0 || len2 < 0) {
            return 0;
        }
        if (text1.charAt(len1) == text2.charAt(len2)) {
            return 1 + longestCommonSubsequence(text1, text2, len1 - 1, len2 - 1);
        } else {
            return Math.max(longestCommonSubsequence(text1, text2, len1 - 1, len2),
                    longestCommonSubsequence(text1, text2, len1, len2 - 1));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence test = new LongestCommonSubsequence();
        System.out.println(test.longestCommonSubsequence("abcde", "ace"));
        //test.longestCommonSubsequence("abcde", "ace");
    }
}
