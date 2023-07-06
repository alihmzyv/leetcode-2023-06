package org.example.linkedlist;

import org.example.common.ListNode;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = merge(head.next);
        ListNode dummyNode = new ListNode(-1, curr);

        while (curr.next != null) {
            curr.next = merge(curr.next);
            curr = curr.next;
        }

        return dummyNode.next;
    }

    private ListNode merge(ListNode node) {
        int sum = 0;
        while (node.val != 0) {
            sum += node.val;
            node = node.next;
        }
        return new ListNode(sum, node.next);
    }

    /*
    Less clean, but faster
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        while (head.next != null) { // no NullPointer -> statement: The number of nodes in the list is in the range [3, 2 * 105].
            ListNode merged = merge(head.next);
            curr.next = merged;
            curr = curr.next;
            head = merged.next;
        }
        curr.next = null;
        return dummyNode.next;
    }

    private ListNode merge(ListNode node) {
        int sum = 0;
        while (node.val != 0) {
            sum += node.val;
            node = node.next;
        }
        return new ListNode(sum, node);
    }
     */
}
