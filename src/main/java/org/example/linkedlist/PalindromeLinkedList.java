package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

public class PalindromeLinkedList {
    /*
    own solution (output to array, time = O(n), space = O(n)
     */
    public boolean isPalindrome(ListNode head) {
            //output to array, did not create another method to get the array, since it would include array copy
            ListNode[] arr = new ListNode[100000];
            int size = 0;
            while (head != null) {
                arr[size++] = head;
                head = head.next;
            }

            //check
            for (int i = 0; i < size / 2; i++) {
                if (arr[i].val != arr[size - i - 1].val)
                    return false;
            }
            return true;
    }

    /*
    TODO: study other approaches
     */
}
