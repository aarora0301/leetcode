package Patterns.TreeBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/***
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class NodesKDistance {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        Set<TreeNode> set = new HashSet<>();

        List<Integer> result = new ArrayList<>();
        int dist = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(target);
        set.add(target);
        while (!queue.isEmpty()) {

            if (dist == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;

            }
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                if (top == null) {
                    continue;
                }

                if (top.left != null && !set.contains(top.left)) {
                    set.add(top.left);
                    queue.add(top.left);
                }

                if (top.right != null && !set.contains(top.right)) {
                    set.add(top.right);
                    queue.add(top.right);
                }

                if (map.get(top) != null && !set.contains(map.get(top))) {
                    set.add(map.get(top));
                    queue.add(map.get(top));
                }
            }
            dist += 1;

        }
        return result;
    }

    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        dfs(root.left, root, map);
        dfs(root.right, root, map);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode target = treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);

        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        NodesKDistance nodesKDistance = new NodesKDistance();
        System.out.println(nodesKDistance.distanceK(treeNode, target, 2).toString());
    }

}
