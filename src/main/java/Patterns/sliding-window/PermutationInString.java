/******
 *  https://leetcode.com/problems/permutation-in-string/
 */

public class PermutationInString {


    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }

        int[] s2freq = new int[26];
        int[] s1freq = inputFrequency(s1);

        for (int i = 0; i < s1.length(); i++) {
            s2freq[s2.charAt(i) - 'a']++;
        }
        if (matchChar(s1freq, s2freq)) {
            return true;
        } else {
            for (int i = s1.length(); i < s2.length(); i++) {
                s2freq[s2.charAt(i - s1.length()) - 'a']--;
                s2freq[s2.charAt(i) - 'a']++;

                if (matchChar(s1freq, s2freq)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static int[] inputFrequency(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        return arr;
    }

    private static boolean matchChar(int[] input, int[] pattern) {
        for (int i = 0; i < 26; i++) {
            if (input[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

}
