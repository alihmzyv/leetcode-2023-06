package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class RemoveLinkedListElements {
    /*
    own solution, time = O(n), space = O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                head = head.next;
                curr = curr.next;
            } else {
                ListNode next = curr.next;
                if (next != null && next.val == val) {
                    curr.next = next.next;
                } else {
                    curr = next;
                }
            }
        }
        return head;
    }
}
