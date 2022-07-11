package Patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] argv) {
        String[] words = new String[]{"cat", "baby", "dog", "bird", "car", "ax"};
        String string1 = "tcabnihjs";
        String string2 = "tbcanihjs";
        String string3 = "baykkjl";
        String string4 = "bbabylkkj";
        String string5 = "ccc";
        String string6 = "breadmaking";
//        Solution solution = new Solution();
//        System.out.println(solution.embeddedWord(words, string1));
    }


    public String embeddedWord(final String[] input, final String word) {
        if (input.length == 0) {
            return "";
        }

        Map<String, boolean[]> map = generateInputMap(input);
        boolean[] inputMeta = getCode(word);
        for (String key : map.keySet()) {
            if (compareArrays(map.get(key), inputMeta)) {
                return key;
            }
        }
        return null;
    }

    public boolean compareArrays(final boolean[] arrMeta, final boolean[] inputMeta) {
        for (int i = 0; i < 26; i++) {

            if (arrMeta[i] == false) {
                continue;
            }
            if (arrMeta[i] == true && inputMeta[i] == false) {
                return false;
            }
        }
        return true;
    }

    private Map<String, boolean[]> generateInputMap(final String[] input) {
        Map<String, boolean[]> map = new HashMap<>();

        for (String word : input) {
            map.put(word, getCode(word));
        }

        return map;
    }

    private boolean[] getCode(final String word) {

        boolean[] flag = new boolean[26];

        for (char ch : word.toCharArray()) {
            final int index = ch - 'a';
            flag[index] = true;
        }
        return flag;

    }
}
