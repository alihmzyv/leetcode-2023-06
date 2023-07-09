package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class MergeTwoSortedLists {
    /*
    MY OWN SOLUTION (modified based on a sample solution), time = O(n), space = O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }
            else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1; //in prev. sol., I iterated through the whole rest of the lest nodes
        return dummy.next;
    }

    /*
    Recursive solution - time O(n), space O(n)
     */
    public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
