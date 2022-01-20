package Facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        char right = s.charAt(s.length() - 1);
        int sum = lookup.get(right);
        for (int i =s.length() - 2; i >= 0 ; i--) {
            if (lookup.get(s.charAt(i)) >= lookup.get(right)) {
                sum += lookup.get(s.charAt(i));
            } else {
                sum -= lookup.get(s.charAt(i));
            }

            right = s.charAt(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

}
