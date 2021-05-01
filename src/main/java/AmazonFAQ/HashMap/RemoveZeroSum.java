package main.java.AmazonFAQ.HashMap;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSum {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefix = 0;
        ListNode curr = dummy;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(prefix, dummy);
        while (curr != null) {
            prefix += curr.val;
            map.put(prefix, curr);
            curr = curr.next;

        }

        prefix = 0;
        curr = dummy;
        while (curr != null) {
            prefix += curr.val;
            curr.next = map.get(prefix).next;
            curr= curr.next;
        }

        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}