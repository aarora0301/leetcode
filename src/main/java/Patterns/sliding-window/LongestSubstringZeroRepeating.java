import java.util.HashMap;
import java.util.Map;

public class LongestSubstringZeroRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0, maxLength = Integer.MIN_VALUE;
        char curr = Character.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, i);
            } else {
                start = map.get(curr) + 1;
                map.put(curr, i);
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int test1 = lengthOfLongestSubstring("bcabcbb");
        System.out.println(test1);

        test1 = lengthOfLongestSubstring("bbbbb");
        System.out.println(test1);

        test1 = lengthOfLongestSubstring("pwwkew");
        System.out.println(test1);

        test1 = lengthOfLongestSubstring("");
        System.out.println(test1);
    }

}
