package Patterns.ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 *  Uber OA
 *  A Magic number is a number that remains same after rotating 180 degress
 *   Example : 1, 11, 88, 101, 808, 69, 96
 *
 *   check if a number is a magic number
 */
public class MagicNumber {

    Set<Integer> set = Set.of(2, 3, 4, 5, 7);
    Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 8, 8, 6, 9, 9, 6);

    boolean isMagicNumber(String N) {
        String temp = N;

        int len = temp.length() / 2;
        for (int i = 0; i <= len; i++) {
            int num = Character.getNumericValue(temp.charAt(i));
            if (set.contains(num)) {
                return false;
            } else {
                int _num = Character.getNumericValue(temp.charAt(temp.length() - 1 - i));
                if (num != map.get(_num)) {
                    return false;
                }
            }
        }
        return true;

    }

    /***
     * Generate all magic number of N digits
     */
    private List<String> generateMagicNumbers(String N) {
        List<String> list = new ArrayList<>();
        backTrack(N, new int[]{0, 1, 6, 8, 9}, new StringBuilder(), list);
        return list;
    }

    private void backTrack(String N, int[] arr, StringBuilder str, List<String> list) {
        if (str.length() == Integer.parseInt(N) && isMagicNumber(str.toString())) {
            list.add(str.toString());
            return;
        }
        if (str.length() == Integer.parseInt(N)) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
            backTrack(N, arr, str, list);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        MagicNumber magicNumber = new MagicNumber();
       // System.out.println(magicNumber.isMagicNumber("161"));
        System.out.println(magicNumber.generateMagicNumbers("3"));
    }

}
