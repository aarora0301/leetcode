package Tags.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {


    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int endIndex = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            endIndex = Math.max(endIndex, last[s.charAt(i)]);
            if (i == endIndex) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;

    }

    public static void main(String[] args) {

    }


}
