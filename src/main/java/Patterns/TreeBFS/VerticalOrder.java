package Patterns.TreeBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrder {

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

    static class Pair {

        TreeNode treeNode;
        int val;

        Pair(TreeNode node, int val) {
            treeNode = node;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            if (!map.containsKey(top.val)) {
                map.put(top.val, new ArrayList<>());
            }
            map.get(top.val).add(top.treeNode.val);
            if (top.treeNode.left != null) {
                queue.add(new Pair(top.treeNode.left, top.val - 1));
            }
            if (top.treeNode.right != null) {
                queue.add(new Pair(top.treeNode.right, top.val + 1));
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
       // root.left.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        VerticalOrder verticalOrder = new VerticalOrder();
        System.out.println(verticalOrder.verticalOrder(root).toString());
    }

}
