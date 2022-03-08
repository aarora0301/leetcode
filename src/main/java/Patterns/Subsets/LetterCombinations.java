package Patterns.Subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = getLookUp();
        List<String> result = new ArrayList<>();
        backTrack(map, digits, 0, result, new StringBuilder());
        return result;
    }

    private void backTrack(Map<Character, String> map, String digits, int start, List<String> result,
                           StringBuilder stringBuilder) {
        if (stringBuilder.length() == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        String letters = map.get(digits.charAt(start));
        for (char c : letters.toCharArray()) {
            stringBuilder.append(c);
            backTrack(map, digits, start, result, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    private Map<Character, String> getLookUp() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }


    public static void main(String[] args) {

    }
}
