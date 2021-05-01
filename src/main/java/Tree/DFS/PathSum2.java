package main.java.Tree.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversal(root, result, temp, 0, sum);
        return result;
    }

    private void traversal(TreeNode root, List<List<Integer>> result, List<Integer> temp, int currSum, int givenSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null && currSum == givenSum) {
            result.add(new ArrayList<>(temp));
        }
        traversal(root.left, result, temp, currSum, givenSum);
        if (temp.size() > 0 && root.left != null) {
            temp.remove(temp.size()-1);
        }
        traversal(root.right, result, temp, currSum, givenSum);
        if (temp.size() > 0 && root.right != null) {
            temp.remove(temp.size()-1);
        }
    }
}
