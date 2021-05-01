package main.java.Hard;

/*****
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the
 * shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(0) == s.charAt(i)) {
                if (isPalindrome(s, i)) {
                    break;
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString() + s;
    }

    private boolean isPalindrome(String input, int n) {
        int l = 0, r = n;
        while (l < n) {
            if (input.charAt(l) != input.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
