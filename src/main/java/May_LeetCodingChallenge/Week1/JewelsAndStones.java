package main.java.May_LeetCodingChallenge;


import java.util.HashSet;
import java.util.Set;

/***
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int[] cnt = new int[128];
        int count = 0;
        for (char ch : S.toCharArray()) {
            cnt[ch]++;
        }
        for (char ch : J.toCharArray()) {
            count += cnt[ch];
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones test = new JewelsAndStones();
        System.out.println(test.numJewelsInStones("Aa", "aaaAer"));
    }
}
