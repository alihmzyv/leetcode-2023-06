package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class DeleteNodeInALinkedList {
    /*
    MY OWN SOLUTION, time = O(n), space = O(1)
     */
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }
}
