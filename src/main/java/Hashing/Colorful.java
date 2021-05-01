package main.java.Hashing;


import java.util.HashSet;
import java.util.Set;

/****
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 */

public class Colorful {


    public int colorful(int A) {
        boolean flag = false;
        int result = 1;
        int number = 0;
        Set<Integer> set = new HashSet<>();
        while (A > 0) {
            number = A % 10;
            Set<Integer> subSet = new HashSet<>();
            subSet.addAll(set);
            for (int num : subSet) {
                flag = set.add(num * number);
                if (flag == false) {
                    result = 0;
                    return result;
                }
            }
            flag = set.add(number);
            A = A / 10;
            if (!flag) {
                result = 0;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Colorful test = new Colorful();
        System.out.println(test.colorful(22));
    }
}
