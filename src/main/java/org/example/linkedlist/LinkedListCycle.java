package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> traversed = new HashSet<>(10000);
        while (head != null) {
            if (traversed.contains(head))
                return true;
            else
                traversed.add(head);
            head = head.next;
        }
        return false;
    }
}
