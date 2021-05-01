package main.java.Tree.DFS;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode temp = null;
        if (root.left != null) {
            temp = root.left;
        }
        if (root.right != null) {
            root.left = root.right;
        }
        root.right = temp;
    }
}
