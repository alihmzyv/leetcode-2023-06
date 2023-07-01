package org.example.linkedlist;

import org.example.common.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    /*
    MY OWN SOLUTION - time = O(n), space = O(1)
     */
    public int getDecimalValue(ListNode head) {
        //using doubling
        int decimal = head.val;
        head = head.next;

        while (head != null) {
            decimal = decimal * 2 + head.val;
            head = head.next;
        }

        return decimal;
    }
}
