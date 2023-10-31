package org.example.pickone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumInputArrayIsSortedTest {

    @Test
    void twoSum() {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        TwoSumInputArrayIsSorted twoSumInputArrayIsSorted = new TwoSumInputArrayIsSorted();
        int[] result = twoSumInputArrayIsSorted.twoSum(numbers, 8);
        assertArrayEquals(result, new int[]{4, 5});
    }
}