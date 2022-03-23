package Patterns.TreeBFS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) {
                    queue.add(top.left);
                    list.add(top.left.val);
                }
                if (top.right != null) {
                    queue.add(top.right);
                    list.add(top.right.val);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> reverse = levelOrder.levelOrder(root);
        /**
         * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
         */
        Collections.reverse(reverse);
        System.out.println(reverse.toString());
    }

}
