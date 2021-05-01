package main.java.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/***
 * Given a long make smaller strings of size 140 characters.
 * constraints:
 *    1. if a word is partially covered while making batch ignore that word
 *
 *  Follow up: Handle the case when string has millions of character
 */
public class test {

    public List<String> aggregator(String inpuStr, int limit) {
        String[] dummy = inpuStr.split(" ");
        List<String> result = new ArrayList<>();
        String processStr = "";
        int len = 0;

        for (String word : dummy) {
            if (len + word.length() + 1 < limit) {
                processStr += " " + word;
                len+= 1 + word.length();
            } else {
                result.add(processStr);
                processStr = word;
                len = word.length();
            }
        }
        result.add(processStr);
        return result;
    }

    public static void main(String[] args) {
        TreeMap map= new TreeMap<>();
        map.put("A",1);
        map.put("B",1);
        System.out.println(map.entrySet());
        }

}
