package org.example.linkedlist;

import org.example.common.ListNode;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        //output to array
        int[] vals = new int[100000];
        int size = 0;
        while (head != null) {
            vals[size++] = head.val;
            head = head.next;
        }

        int maxTwinSum = Integer.MIN_VALUE;

        for (int i = 0; i < size / 2; i++) {
            int sum = vals[i] + vals[size - i - 1];
            if (sum > maxTwinSum)
                maxTwinSum = sum;
        }

        return maxTwinSum;
    }
}
