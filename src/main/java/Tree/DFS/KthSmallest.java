package main.java.Tree.DFS;

public class KthSmallest {

    int ans = Integer.MIN_VALUE;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || count > k) {
            return;
        }

        dfs(root.left, k);
        count = count + 1;
        if (count > k) {
            return;
        }
        ans = Math.max(root.val, ans);
        dfs(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallest test = new KthSmallest();
        int i = test.kthSmallest(root, 1);
        System.out.println(i);
    }
}
