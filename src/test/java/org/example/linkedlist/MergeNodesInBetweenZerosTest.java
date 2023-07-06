package org.example.linkedlist;

import org.example.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class MergeNodesInBetweenZerosTest {

    @Test
    void mergeNodes() {
        ListNode list = createList(List.of(0, 3, 1, 0, 4, 5, 2, 0));
        MergeNodesInBetweenZeros test = new MergeNodesInBetweenZeros();
        ListNode listNode = test.mergeNodes(list);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private ListNode createList(List<Integer> nums) {
        ListNode dummyNode = new ListNode();
        final ListNode[] curr = {dummyNode};
        nums.forEach(num -> {
            curr[0].next = new ListNode(num);
            curr[0] = curr[0].next;
        });
        return dummyNode.next;
    }
}