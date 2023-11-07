package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortIntegersByTheNumberOf1BitsTest {
    SortIntegersByTheNumberOf1Bits sortIntegersByTheNumberOf1Bits = new SortIntegersByTheNumberOf1Bits();

    @Test
    void sortByBits() {
        int[] arr = {0,1,2,3,4,5,6,7, 8};
        int[] expected = {0,1,2,4,8,3,5,6,7};
        int[] actual = sortIntegersByTheNumberOf1Bits.sortByBits(arr);
        System.out.println("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}