package org.example.linkedlist;

import org.example.linkedlist.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.example.linkedlist.MergeNodesInBetweenZerosTest.createList;

class SpiralMatrix4Test {

    @Test
    void spiralMatrix() {
        ListNode list = createList(List.of(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0));
        SpiralMatrix4 spiralMatrix4 = new SpiralMatrix4();
        int[][] matrix = spiralMatrix4.spiralMatrix(3, 5, list);
        for (int[] mtrx : matrix) {
            System.out.println(Arrays.toString(mtrx));
        }
    }
}