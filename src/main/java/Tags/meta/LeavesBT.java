package Tags.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeavesBT {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map);
        return new ArrayList<>(map.values());

    }

    private int dfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root==null){
            return 0;
        }
        int left= dfs(root.left, map);
        int right= dfs(root.right, map);
        int height= Math.max(left, right)+1;
        List<Integer> list= map.getOrDefault(height, new ArrayList<>());
        list.add(root.val);
        map.put(height, list);
        return height;
    }


    class TreeNode {
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
}
