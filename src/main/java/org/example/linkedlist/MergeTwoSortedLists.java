package org.example.linkedlist;

import org.example.common.ListNode;

import java.util.List;

public class MergeTwoSortedLists {
    /*
    MY OWN SOLUTION, time = O(n), space = O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode refToNewHead = null;
        ListNode chosen = null;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                if (refToNewHead == null) {
                    chosen = list1;
                    refToNewHead = list1;
                } else {
                    chosen.next = list1;
                    chosen = list1;
                }
                list1 = list1.next;
            } else {
                if (refToNewHead == null) {
                    chosen = list2;
                    refToNewHead = list2;
                } else {
                    chosen.next = list2;
                    chosen = list2;
                }
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            while (list2 != null) {
                if (refToNewHead == null) {
                    refToNewHead = list2;
                } else {
                    chosen.next = list2;
                }
                chosen = list2;
                list2 = list2.next;
            }
        } else {
            while (list1 != null) {
                if (refToNewHead == null) {
                    refToNewHead = list1;
                } else {
                    chosen.next = list1;
                }
                chosen = list1;
                list1 = list1.next;
            }
        }

        return refToNewHead;
    }
}
