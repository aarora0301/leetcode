package Leetcode.Arrays;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * <p>
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 */
public class FindWords {

    public int countCharacters(String[] words, String chars) {
        int[] parent = count(chars);
        int count = 0;
        int[] temp;
        for (String word : words) {
            temp = count(word);
            if (isGoodWord(word, parent, temp)) {
                count += word.length();
            }
        }
        return count;
    }


    boolean isGoodWord(String word, int[] parent, int[] temp) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (parent[index] == 0) {
                return false;
            }
            if (temp[index] <= parent[index]) {
                continue;
            } else return false;
        }
        return true;

    }

    private int[] count(String str) {
        int[] temp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i) - 'a']++;
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        FindWords fw = new FindWords();
        System.out.println(fw.countCharacters(words, chars));
    }
}
