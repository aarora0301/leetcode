package main.java.May_LeetCodingChallenge.Week3;

import java.util.ArrayList;
import java.util.List;

public class Anagrams_Optimised {

    public List<Integer> findAnagrams(String s, String p) {
        int strLength = s.length(), patternLength = p.length();
        if (patternLength > strLength) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        for (int i = 0; i < patternLength; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = patternLength; i < strLength; i++) {
            if (countZeroes(count)) {
                list.add(i - patternLength);
            }
            count[s.charAt(i) - 'a']++;
            /**
             *  Sliding window algorithm
             *  s= abcab   p= ab
             *   iteration 1: find countArr for ab
             *   iteration 2: find countArr for abc -a ==> countArr for string : bc  and so on...
             */
            count[s.charAt(i - patternLength) - 'a']--;
        }
        if (countZeroes(count)) {
            list.add(strLength - patternLength);
        }
        return list;
    }

    private boolean countZeroes(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagrams_Optimised test = new Anagrams_Optimised();
        System.out.println(test.findAnagrams("abcab", "ab"));
    }
}
