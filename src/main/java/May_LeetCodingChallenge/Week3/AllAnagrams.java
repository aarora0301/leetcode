package main.java.May_LeetCodingChallenge.Week3;

import java.util.ArrayList;
import java.util.List;

/****
 *  Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class AllAnagrams {

    /**
     * Time Limit Exceeded
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int patternLength = p.length();
        int[] patternCount = new int[26];
        for (int i = 0; i < patternLength; i++) {
            patternCount = createCountArray(p);
        }
        List<Integer> result = new ArrayList<>();
        int[] inputCount;
        for (int i = 0; i + patternLength - 1 < s.length(); i++) {
            String test = s.substring(i, i + patternLength);
            inputCount = createCountArray(test);
            if (compareCounts(patternCount, inputCount)) {
                result.add(i);
            }
        }
        return result;

    }

    private boolean compareCounts(int[] patternCount, int[] inputCount) {
        for (int i = 0; i < 26; i++) {
            if (patternCount[i] != inputCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] createCountArray(String input) {
        int[] count = new int[26];
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            index = input.charAt(i) - 'a';
            count[index]++;
        }
        return count;
    }

    public static void main(String[] args) {
        AllAnagrams test = new AllAnagrams();
        System.out.println(test.findAnagrams("abab", "ab"));
    }
}
