package main.java.Tree.DFS;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {


    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        dfs(root, sum, 0, hashMap);
        return count;
    }

    private void dfs(TreeNode root, int sum, int currSum, Map<Integer, Integer> hashMap) {
        if (root == null) {
            return;
        }
        currSum += root.val;

        if (currSum == sum) {
            count++;
        }

        count += hashMap.getOrDefault(currSum - sum, 0);

        hashMap.put(currSum, hashMap.getOrDefault(currSum, 0) + 1);

        dfs(root.left, sum, currSum, hashMap);
        dfs(root.right, sum, currSum, hashMap);
        hashMap.put(currSum, hashMap.get(currSum) - 1);
    }

    public static void main(String[] args) {

    }
}
