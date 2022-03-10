package Patterns.TreeDFS;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LCABT {

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


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);
        stack.push(root);

        while (map.containsKey(p) == false || map.containsKey(q) == false) {

            if (stack.isEmpty()) {
                break;
            }

            TreeNode top = stack.pop();
            if (top.left != null) {
                map.put(top.left, top);
                stack.push(top.left);
            }
            if (top.right != null) {
                map.put(top.right, top);
                stack.push(top.right);
            }

        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = map.get(p);

        }

        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        return q;
    }


    public static void main(String[] args) {
        LCABT lcabt = new LCABT();
        TreeNode treeNode = new TreeNode(3);
        TreeNode p = treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        TreeNode q = treeNode.left.right.right = new TreeNode(4);

        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        System.out.println(lcabt.lowestCommonAncestor(treeNode, p, q).val);

    }

}
