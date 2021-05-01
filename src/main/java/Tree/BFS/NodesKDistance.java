package main.java.Tree.BFS;

import java.util.*;

public class NodesKDistance {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        /***
         *  fill child to parent map
         */
        preOrderTraversal(root, map, null);
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        set.add(target);
        int currentLevel = 0;
        while (!queue.isEmpty()) {

            if (currentLevel == K) {
                return extractListFromQueue(queue);
            }
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++) {

                TreeNode top = queue.poll();

                if (top.left != null && !set.contains(top.left)) {
                    queue.add(top.left);
                    set.add(top.left);
                }
                if (top.right != null && !set.contains(top.right)) {
                    queue.add(top.right);
                    set.add(top.right);
                }

                TreeNode parent = map.get(top);
                if (parent != null && !set.contains(parent)) {
                    set.add(parent);
                    queue.add(parent);
                }

            }
            currentLevel++;

        }
        return new ArrayList<Integer>();

    }


    private void preOrderTraversal(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(root, parent);
        preOrderTraversal(root.left, map, root);
        preOrderTraversal(root.right, map, root);
    }

    private List<Integer> extractListFromQueue(Queue<TreeNode> queue) {
        List<Integer> list = new ArrayList<>();
        for (TreeNode temp : queue) {
            list.add(temp.val);
        }
        return list;
    }
}
