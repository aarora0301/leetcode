package Patterns.TreeDFS;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        inOrder(root, new ArrayList<>(), result, 0, targetSum);
        return result;

    }

    private void inOrder(TreeNode root, List<Integer> list, List<List<Integer>> result, int currSum, int targetSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(list));
        } else {
            inOrder(root.left, list, result, currSum, targetSum);
            inOrder(root.right, list, result, currSum, targetSum);
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

    }

}
