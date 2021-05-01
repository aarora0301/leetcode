package main.java.Tree.DFS;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return checkSum(root, sum, 0);
    }

    public boolean checkSum(TreeNode root, int givenSum, int currSum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == givenSum) {
            return true;
        }

        return checkSum(root.left, givenSum, currSum) || checkSum(root.right, givenSum, currSum);
    }
}
