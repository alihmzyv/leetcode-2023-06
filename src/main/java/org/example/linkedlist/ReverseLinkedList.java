package org.example.linkedlist;

import org.example.common.ListNode;

public class ReverseLinkedList {
    /*
    MY OWN ITERATIVE SOLUTION
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNodeRef = head.next;
            head.next = prev;
            prev = head;
            head = nextNodeRef;
        }
        return prev;
    }

    /*
    MY OWN RECURSIVE SOLUTION
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null)
            return null;
        return swap(null, head);
    }

    private ListNode swap(ListNode former, ListNode latter) {
        ListNode refToNext = latter.next;
        latter.next = former;
        if (refToNext == null) {
            return latter;
        }
        return swap(latter, refToNext);
    }
}
