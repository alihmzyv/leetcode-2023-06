package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            swap(head, head.next);
            return newHead;
        }
    }

    private void swap(ListNode node1, ListNode node2) {
        ListNode temp = node2.next;
        node2.next = node1;
        node1.next = temp;
        if (temp != null) {
            swap(temp, temp.next);
        }
    }
}
