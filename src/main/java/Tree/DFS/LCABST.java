package main.java.Tree.DFS;

public class LCABST {

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = Min(p, q);
        TreeNode max = Max(p, q);
        dfs(root, min, max);
        return result;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if (root.val >= p.val && root.val <= q.val) {
            result = root;
            return;
        }
        if (root.val > p.val && root.val > q.val) {
            dfs(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            dfs(root.right, p, q);
        }
    }

    TreeNode Max(TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return p;
        } else {
            return q;
        }
    }

    TreeNode Min(TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return p;
        } else {
            return q;
        }
    }

    public static void main(String[] args) {
        LCABST bst = new LCABST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        TreeNode te = bst.lowestCommonAncestor(root, root, root.left);
        System.out.println(te.val);
    }
}
