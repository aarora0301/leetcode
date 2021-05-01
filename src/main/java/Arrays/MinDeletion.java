package main.java.Arrays;

import java.util.HashSet;
import java.util.Set;

public class MinDeletion {

    int ans = 0;

    public int getMinDeletions(String s) {
        populateArray(s);
        return ans;
    }

    private void populateArray(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                ans += 1;
            } else {
                set.add(ch);
            }
        }
        return;
    }

    public static void main(String[] args) {
        MinDeletion test = new MinDeletion();
        int res = test.getMinDeletions("abcab");
        System.out.println(res);
    }
}
