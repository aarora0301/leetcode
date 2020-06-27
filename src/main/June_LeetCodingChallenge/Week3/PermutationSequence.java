package main.June_LeetCodingChallenge.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 */
public class PermutationSequence {


    private String result = "";
    int count= 0;

    public String getPermutation(int n, int k) {

        StringBuilder str= new StringBuilder();
        for (int i=1 ; i<=n; i++){
            str.append(i);
        }
        permute(k, str.toString().toCharArray(), 0);
        return result;
    }

    public void permute(int k,  char[] num, int start) {
        if (start == num.length - 1) {
            count++;
            if (count == k) {
                result = String.valueOf(num);
            }
            return;
        }
        for (int i = start; i < num.length; i++) {
            swap(num, start, i);
            permute(k, num, start + 1);
            swap(num, start, i);
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        int k=3;
        System.out.println(test.getPermutation(3, 6));
    }
}
