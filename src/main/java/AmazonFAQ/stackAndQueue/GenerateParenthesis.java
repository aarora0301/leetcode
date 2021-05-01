package main.java.AmazonFAQ.stackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> ans, String curr, int open, int close, int max) {
        if (curr.length()==2*max){
            ans.add(curr);
            return;
        }
        if (open<max){
            backtrack(ans, curr+ "(", open+1, close, max);
        }
        if (close<open){
            backtrack(ans, curr+")", open, close+1, max);
        }
    }

    public static void main(String[] args) {

    }


}
