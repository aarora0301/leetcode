import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/****
 *
 *                1                 1
 *            2       3       3        2
 *       4      5                  5      4
 *
 *       PreOrder
 *       PostOrder
 *
 *
 *
 */


public class CoinSwitch {


    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode top = queue.poll();

                System.out.print(top.value + " ");

                if (top.left != null) {
                    queue.add(top.left);
                }

                if (top.right != null) {
                    queue.add(top.right);
                }

            }
            System.out.println();
        }
    }

    public TreeNode mirrorTraversal(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode leftNode = mirrorTraversal(root.left);
        TreeNode rightNode = mirrorTraversal(root.right);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    public static void main(String[] args) {

    }


    public class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
