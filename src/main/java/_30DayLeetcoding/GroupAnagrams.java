package main.java._30DayLeetcoding;

import java.util.*;
import java.util.stream.Stream;

/***
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list;
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            String key = keyFromWord(word);
            if (!map.containsKey(key)) {
                list = new ArrayList<>();
                list.add(word);
            } else {
                list = map.get(key);
                list.add(word);
            }
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> sub;
        for (Map.Entry mapElement : map.entrySet()) {
            sub = (ArrayList<String>) mapElement.getValue();
            result.add(sub);
        }
        return result;
    }


    public String keyFromWord(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        List<List<String>> list = test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Stream.of(list)
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }
}
