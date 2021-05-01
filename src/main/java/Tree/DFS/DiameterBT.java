package main.java.Tree.DFS;

public class DiameterBT {

    int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            diameter = 0;
        } else {
            height(root);
        }
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}
