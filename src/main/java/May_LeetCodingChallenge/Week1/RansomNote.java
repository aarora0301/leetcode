package main.java.May_LeetCodingChallenge.Week1;

/****
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Constraints:
 *
 * You may assume that both strings contain only lowercase letters.
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']--;
        }

        for(int val : count) if(val > 0) return false;
        return true;
    }




    public static void main(String[] args) {
        RansomNote test = new RansomNote();
        System.out.println(test.canConstruct("aa", "ab"));
    }
}
