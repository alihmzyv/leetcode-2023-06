package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list = toList(head);
        ListNode kthNodeFromBeginning = list.get(k - 1);
        ListNode kthNodeFromEnd = list.get(list.size() - k);
        int kthNodeFromBeginningVal = kthNodeFromBeginning.val;
        kthNodeFromBeginning.val = kthNodeFromEnd.val;
        kthNodeFromEnd.val = kthNodeFromBeginningVal;
        return head;
    }

    private List<ListNode> toList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }
}
