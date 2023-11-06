package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class MergeInBetweenLinkedLists {
    /*
    own solution - time = O(n1 + n2), space = O(1)
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA = move(list1, a - 1);
        ListNode nodeAfterB = move(nodeBeforeA, b - a + 2);

        //join the second list
        nodeBeforeA.next = list2;
        ListNode list2Tail = getTailOf(list2);
        list2Tail.next = nodeAfterB;

        return list1;
    }

    private ListNode getTailOf(ListNode list2) {
        while (list2.next != null) {
            list2 = list2.next;
        }
        return list2;
    }

    private ListNode move(ListNode node, int times) {
        for (int i = times; i > 0; i--) {
            node = node.next;
        }
        return node;
    }
}
