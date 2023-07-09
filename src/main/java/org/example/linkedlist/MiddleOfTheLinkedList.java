package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class MiddleOfTheLinkedList {
    /*
    MY OWN SOLUTION - time = O(n) (2n), space = O(1)
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

    /*
    OUTPUT TO ARRAY SOLUTION - time = O(n), space = O(n)
     */
    public ListNode middleNodeArraySol(ListNode head) {
        ListNode[] arr = new ListNode[100];//it is stated that the length of linked list is between 1 and 100
        int t = 0;
        while (head != null) {
            arr[t++] = head;
            head = head.next;
        }
        return arr[arr.length / 2];
    }

    /*
    Fast and Slow pointer - time = O(n), space = O(1) - best solution
     */
    public ListNode middleNodeFastAndSlow(ListNode head) {
        ListNode slowPnt = head;
        ListNode fastPnt = head;
        while (fastPnt != null && fastPnt.next != null) {
            slowPnt = slowPnt.next;
            fastPnt = fastPnt.next.next;
        }
        return slowPnt;
    }
}
