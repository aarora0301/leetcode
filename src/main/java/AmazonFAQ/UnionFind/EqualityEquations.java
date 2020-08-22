package main.java.AmazonFAQ.UnionFind;

import java.util.Arrays;

/****
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * Example 2:
 *
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 *
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 *
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 *
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 */
public class EqualityEquations {

    public static void main(String[] args) {
        EqualityEquations equations= new EqualityEquations();
        System.out.println(equations.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }


    public boolean equationsPossible(String[] equations) {
        Arrays.sort(equations, (String a, String b) -> b.substring(1, 3).compareTo(a.substring(1, 3)));
        final UF uf = new UF(26);
        for (String str : equations) {
            int a = str.charAt(0)- 'a';
            int b = str.charAt(3)- 'a';
            int sign = str.substring(1, 3).equals("==") ? 1 : 0;
            if (sign == 1) {
                uf.union(a, b);
            } else {
                if (uf.connected(a, b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
