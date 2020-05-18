package main.java.May_LeetCodingChallenge.Week3;

/****
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] countArray = new int[26];

        for (int i = 0; i < s1Length; i++) {
            countArray[s2.charAt(i) - 'a']++;
            countArray[s1.charAt(i) - 'a']--;
        }
        for (int i = s1Length; i < s2Length; i++) {
            if (areAllZero(countArray)) {
                return true;
            }
            countArray[s2.charAt(i) - 'a']++;
            countArray[s2.charAt(i - s1Length) - 'a']--;
        }

        if (areAllZero(countArray)) {
            return true;
        }
        return false;
    }

    boolean areAllZero(int[] countArr) {
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
