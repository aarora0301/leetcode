import java.util.HashMap;
import java.util.Map;

/****'
 *  https://leetcode.com/problems/longest-repeating-character-replacement/
 */

public class LongestRepeatingCharReplacement {


    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxFreq = Integer.MIN_VALUE, windowStart = 0, frq = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));

            while (i - windowStart + 1 - maxFreq > k) {
                frq = map.get(s.charAt(windowStart));
                frq--;
                map.put(s.charAt(windowStart), frq);
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }

}
