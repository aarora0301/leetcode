package main.java.Tree.DFS;

import java.util.*;

public class LCABT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> result = new ArrayList<>();
        Deque<TreeNode> dummy = new LinkedList<>();
        dfs(root, p, q, dummy, result);
        TreeNode temp = null;
        List<TreeNode> list1 = result.get(0);
        List<TreeNode> list2 = result.get(1);
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); i++, j++) {
            if (list1.get(i) == list2.get(j)) {
                temp = list1.get(i);
            }
        }
        return temp;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, Deque<TreeNode> dummy, List<List<TreeNode>> result) {
        if (root == null) {
            return;
        }

        dummy.add(root);
        if (root == p || root == q) {
            result.add(new LinkedList<>(dummy));
        }


        dfs(root.left, p, q, dummy, result);
        dfs(root.right, p, q, dummy, result);

        if (dummy.size() >= 1 && (root != p || root != q)) {
            dummy.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        TreeNode q = root.left.right.right = new TreeNode(4);
         root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LCABT bt = new LCABT();
        TreeNode ans = bt.lowestCommonAncestor(root, p, q);
        System.out.println(ans.val);

    }
}
