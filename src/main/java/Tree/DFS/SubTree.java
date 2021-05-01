package main.java.Tree.DFS;

public class SubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    public static void main(String[] args) {

    }
}
