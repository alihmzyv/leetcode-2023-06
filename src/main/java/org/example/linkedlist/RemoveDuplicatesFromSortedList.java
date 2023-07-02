package org.example.linkedlist;

import org.example.common.ListNode;

/*
Problem @: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    /*
    OWN SOLUTION, time = O(n), space = O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.val == prev.val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return head;
    }
}
