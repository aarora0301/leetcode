package Patterns.TreeDFS;

public class InvertBinaryTree {

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

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        return preOrder(root);
    }

    public TreeNode preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = preOrder(root.right);
        newRoot.right = preOrder(root.left);
        return newRoot;
    }

}
