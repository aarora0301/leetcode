package main.java.May_LeetCodingChallenge.Week3;

/****
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest
 * frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementBST {

    int count, ans;
    /**
     * Follow up
     */
    DNode head;
    DNode temp;

    /**
     * @param root
     * @param k
     * @return
     */

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        /***
         * Follow up
         *  Create double linked list first time
         *  then do insertion/deletion/search from this linked list
         */
        if (head == null) {
            head = new DNode();
            head.val = root.val;
            temp = new DNode();
            temp = head;
        } else {
            DNode latest = new DNode();
            latest.val = root.val;
            temp.next = latest;
            latest.prev = temp;
            temp = temp.next;
        }
        /**
         *  end of follow up code
         */


        inorder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        KthSmallestElementBST test = new KthSmallestElementBST();
        System.out.println(test.kthSmallest(root, 3));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class DNode {
    int val;
    DNode next, prev;
}
