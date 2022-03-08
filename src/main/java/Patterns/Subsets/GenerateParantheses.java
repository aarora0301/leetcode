package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), list);
        return list;
    }

    private void backtrack(int n, int open, int close, StringBuilder stringBuilder, List<String> result) {

        if (stringBuilder.length() == n * 2) {
            result.add(stringBuilder.toString());
            return;
        }
        if (open < n) {
            stringBuilder.append("(");
            backtrack(n, open + 1, close, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(")");
            backtrack(n, open, close + 1, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public static void main(String[] args) {
        GenerateParantheses generateParantheses = new GenerateParantheses();
        System.out.println(generateParantheses.generateParenthesis(3));

    }

}
