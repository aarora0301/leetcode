package main.java.Tree.BFS;

public class MinDepth {

    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            depth = 0;
        } else if (root.left != null && root.right != null) {
            depth = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left == null) {
            depth = 1 + minDepth(root.right);
        } else if (root.right == null) {
            depth = 1 + minDepth(root.left);
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MinDepth test = new MinDepth();
        int ans = test.minDepth(root);
        System.out.println(ans);
    }
}
