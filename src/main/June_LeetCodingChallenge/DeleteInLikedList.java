package main.June_LeetCodingChallenge;

/***
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * constraints:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class DeleteInLikedList {


    public void deleteNode(ListNode node) {
       swap(node, node.next);
       ListNode next= node.next;
       node.next=next.next;
    }


    private void swap(ListNode curr, ListNode next) {
        int temp = curr.val;
        curr.val = next.val;
        next.val = temp;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next= new ListNode(5);
        root.next.next= new ListNode(1);
        root.next.next.next= new ListNode(9);
        DeleteInLikedList test= new DeleteInLikedList();
        test.deleteNode(root.next);
        System.out.println(root);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }