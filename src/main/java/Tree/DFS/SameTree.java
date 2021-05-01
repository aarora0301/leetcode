package main.java.Tree.DFS;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    private boolean preOrder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return preOrder(p.left, q.left) && preOrder(p.right, q.right);
    }
}
