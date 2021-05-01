package main.java.Easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/****
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the
 * intersected node in A; There are 3 nodes before the intersected node in B.
 *
 */
public class IntersectionOfLinkedLists {

    /***
     * Using Set
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }

    /***
     *  Two Pointers approach
     * @param headA
     * @param headB
     * @return
     */
    public ListNode _getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(5);
        a.next.next.next = new ListNode(7);
        a.next.next.next.next = new ListNode(9);
        a.next.next.next.next.next = new ListNode(11);

        ListNode b = new ListNode(2);
        b.next = new ListNode(4);
        b.next.next = new ListNode(9);
        b.next.next.next = new ListNode(11);
        IntersectionOfLinkedLists test = new IntersectionOfLinkedLists();
        test._getIntersectionNode(a, b);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}