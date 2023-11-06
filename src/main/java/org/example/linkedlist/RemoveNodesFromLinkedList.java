package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList {
    /*
    My own solution - time comp. = O(n^2), space = O(n)
     */
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> newLinkedListStack = new Stack<>();

        while (head != null) {
            if (newLinkedListStack.isEmpty()) {
                newLinkedListStack.push(head);
            } else {
                ListNode lastNode = newLinkedListStack.peek();

                if (head.val > lastNode.val) {
                    newLinkedListStack.pop();
                    continue;
                } else {
                    lastNode.next = head;
                    newLinkedListStack.push(head);
                }
            }
            head = head.next;
        }

        return newLinkedListStack.firstElement();
    }
}
