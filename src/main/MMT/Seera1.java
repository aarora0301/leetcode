package main.MMT;

import java.util.ArrayList;
import java.util.List;

public class Seera1 {

    public static String StringChallenge(String str) {
        // code goes here


        if (str == null || str.length() == 0) {
            return "false";
        }
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                A.add(i);
            } else if (str.charAt(i) == 'b') {
                B.add(i);
            }
        }


        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (Math.abs(A.get(i) - B.get(j)) - 1 == 3) {
                    return "true";
                }
            }
        }
        return "false";
    }

    public static void main(String[] args) {
        // keep this function call here
        String ans = StringChallenge("after badly");
        System.out.println(ans);
        ans = StringChallenge("Laura sobs");
        System.out.println(ans);
    }
}
