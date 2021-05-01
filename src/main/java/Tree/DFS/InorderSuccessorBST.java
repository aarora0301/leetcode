package main.java.Tree.DFS;

public class InorderSuccessorBST {

    TreeNode ans = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (p.val < root.val) {
            ans = root;
            dfs(root.left, p);
        } else {
            dfs(root.right, p);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        InorderSuccessorBST bst = new InorderSuccessorBST();
        TreeNode res = bst.inorderSuccessor(root, root.left.left);
        System.out.println(res.val);
    }
}
