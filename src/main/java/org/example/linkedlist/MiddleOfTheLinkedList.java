package org.example.linkedlist;

import org.example.common.ListNode;

public class MiddleOfTheLinkedList {
    /*
    MY OWN SOLUTION
     */
    public ListNode middleNode(ListNode head) {
        int indexOfMiddle = getSize(head) / 2 + 1;
        while (indexOfMiddle > 1) {
            head = head.next;
            indexOfMiddle--;
        }

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }


}
