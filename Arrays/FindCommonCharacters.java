package Leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 * <p>
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        int[] first = count(A[0]);

        for (String str : A) {
            first = intersection(first, count(str));
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            /**
             * select values which are present after intersection
             */
            if (first[i] != 0) {
                char c = 'a';
                c += i;
                String s = String.valueOf(c);
                while (first[i] > 0) {
                    result.add(s);
                    first[i]--;
                }
            }
        }
        return result;

    }

    /**
     * find intersection of two strings
     *
     * @param a
     * @param b
     * @return
     */
    private int[] intersection(int[] a, int[] b) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = Math.min(a[i], b[i]);
        }
        return arr;
    }

    /**
     * maintain count of letters
     *
     * @param str
     * @return
     */
    private int[] count(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }

    public static void main(String[] args) {
        FindCommonCharacters fc = new FindCommonCharacters();
        String[] arr = {"bella", "label", "roller"};
        List<String> list = fc.commonChars(arr);
        System.out.println(list);
    }
}
