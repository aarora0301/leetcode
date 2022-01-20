import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class KSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode();
        ListNode temp = head;
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode top = priorityQueue.poll();
            ListNode curr = new ListNode();
            curr.val = top.val;
            if (top.next != null) {
                priorityQueue.add(top.next);
            }
            temp.next = curr;
            temp = temp.next;
        }
        return head.next;
    }

    /***
     *  Taking Two Lists at a time
     * @param lists
     * @return
     */
    public ListNode _mergeKLists(ListNode[] lists) {
        ListNode temp = null;

        for (ListNode node : lists) {
            temp = mergeLists(temp, node);
        }
        return temp;
    }

    private ListNode mergeLists(ListNode node1, ListNode node2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        ListNode temp = head;
        ListNode temp1 = node1;
        ListNode temp2 = node2;
        while (temp1 != null && temp2 != null) {
            ListNode node = new ListNode();
            if (temp1.val <= temp2.val) {
                node.val = temp1.val;
                temp1 = temp1.next;
            } else {
                node.val = temp2.val;
                temp2 = temp2.next;
            }
            temp.next = node;
            temp = temp.next;
        }
        if (temp2 == null) {
            temp.next = temp1;
        } else if (temp1 == null) {
            temp.next = temp2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode temp2 = new ListNode(5);
        ListNode temp = new ListNode(4, temp2);
        ListNode listNode1 = new ListNode(1, temp);

        temp2 = new ListNode(4);
        temp = new ListNode(3, temp2);
        ListNode listNode2 = new ListNode(1, temp);

        temp2 = new ListNode(6);
        ListNode listNode3 = new ListNode(2, temp2);

        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        KSortedLists kSortedLists = new KSortedLists();
        ListNode ll = kSortedLists.mergeKLists(listNodes);
        while (ll != null) {
            System.out.print(ll.val + " ");
            ll = ll.next;
        }
    }
}


class ListNode {

    public int getVal() {
        return val;
    }

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
