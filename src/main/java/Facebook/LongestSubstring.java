package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxWin = Integer.MIN_VALUE;
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, i);
            maxWin = Math.max(maxWin, i - start + 1);
        }
        return maxWin;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

}
