package main.java.AmazonFAQ.SlidingWindow;

public class NumberOFStrings {

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int ans = 0, res = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;

            while (j < s.length() && count[0] > 0 && count[1] > 1 && count[2] > 0) {
                ans++;
                count[s.charAt(j) - 'a']--;
                j++;
            }
            res += ans;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
