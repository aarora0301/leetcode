package Patterns.TreeDFS;

public class LCABST {

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

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }

    public static void main(String[] args) {
        LCABST lcabst = new LCABST();

    }

}
