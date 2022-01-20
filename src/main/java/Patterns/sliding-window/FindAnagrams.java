import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAnagrams {


    public static List<Integer> _findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        char[] tempCh = p.toCharArray();
        Arrays.sort(tempCh);
        String temp = String.valueOf(tempCh);

        for (int i = 0; i <= s.length() - p.length(); i++) {
            tempCh = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(tempCh);
            String input = String.valueOf(tempCh);

            if (temp.equals(input)) {
                result.add(i);
            }
        }
        return result;

    }

    public static List<Integer> findAnagrams(String s, String p) {

        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        int[] input = new int[26];
        int[] pattern = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pattern[p.charAt(i) - 'a']++;
            input[s.charAt(i) - 'a']++;
        }

        if (isAnagram(pattern, input)) {
            result.add(0);
        }
        int j = 0;

        int inputCount = 1;
        while (inputCount + p.length() - 1 < s.length()) {
            input[s.charAt(inputCount - 1) - 'a']--;
            input[s.charAt(inputCount + p.length() - 1) - 'a']++;
            if (isAnagram(pattern, input)) {
                result.add(inputCount);
            }
            inputCount++;
        }
        return result;
    }

    private static boolean isAnagram(int[] pattern, int[] input) {
        for (int i = 0; i < 26; i++) {
            if (pattern[i] != input[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> list = null;

        list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list.toString());

                        list = findAnagrams("abab", "ab");
                        System.out.println(list.toString());

                list = findAnagrams("baa", "aa");
                System.out.println(list);

                list = findAnagrams("abaacbabc", "abc");
                System.out.println(list);
    }

}
