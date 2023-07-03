package org.example.linkedlist;

import org.example.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {
    public static ListNode getLinkedList(String num) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        for (int i = 0; i < num.length(); i++) {
            curr.next = new ListNode(Integer.parseInt(String.valueOf(num.charAt(i))));
            curr = curr.next;
        }
        return dummyNode.next;
    }

    @Test
    void isPalindrome() {
        ListNode head = getLinkedList("1221");
        PalindromeLinkedList obj = new PalindromeLinkedList();
        assertTrue(obj.isPalindrome(head));
    }
}