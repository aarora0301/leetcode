package Patterns.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring1 {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 1));
        }
        int counter = map.size();
        int begin = 0, end = 0, len = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }

            while (counter == 0) {
                Character ch = s.charAt(begin);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);

                    if (map.get(ch) > 0) {
                        counter++;
                    }
                }

                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head + len);
    }

    public static void main(String[] args) {

    }

}
