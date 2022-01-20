import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * Description
 * Given a string S, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Input: S = "eceba" and k = 3
 * Output: 4
 * Explanation: T = "eceb"
 *
 *
 * Input: S = "WORLD" and k = 4
 * Output: 4
 * Explanation: T = "WORL" or "ORLD"
 *
 *   "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh"
 *
 *
 * Challenge
 * O(n) time
 */

public class LongestSubstringWithAtmostKDistinct {

    public static void main(String[] args) {
        int test1 = lengthOfLongestSubstringKDistinct("ecebaaab", 3);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("w", 0);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("kb", 10);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("w", 1);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("eceba", 3);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("WORLD", 4);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16);
        System.out.println(test1);

        test1 = lengthOfLongestSubstringKDistinct("eeecccaacccc", 2);
        System.out.println(test1);
    }

    /****
     *  Time Exceeded'
     * @param s
     * @param k
     * @return
     */
    public static int _lengthOfLongestSubstringKDistinct(String s, int k) {

        /**
         *  Solution 1
         */
        if (s == null || s.length() == 0 || k==0) {
            return 0;
        }
        // write your code here
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() > k) {
                    maxLen = Math.max(maxLen, j - i);
                    break;
                }

                maxLen = Math.max(maxLen, j - i + 1);
                if (maxLen == 27) {
                    System.out.println("i: " + i + " j:" + j);
                }

            }
        }

        return maxLen;

    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s == null || s.length() == 0|| k==0) {
            return 0;
        }
        int start = 0, count = 0, maxWin = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr)) {
                count++;
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while (count > k) {
                int freq = map.get(s.charAt(start));
                freq--;
                map.put(s.charAt(start), freq);

                if (freq == 0) {
                    map.remove(s.charAt(start));
                    count--;
                }
                start++;

            }
            maxWin = Math.max(maxWin, i - start + 1);
        }
        return maxWin;
    }

}

