package main.java.May_LeetCodingChallenge.Week4;

import java.util.PriorityQueue;

/****
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            count[index]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 0; i < 256; i++) {
            if (count[i] == 0) {
                continue;
            }
            pq.offer((char) i);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            for (int i = 0; i < count[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
