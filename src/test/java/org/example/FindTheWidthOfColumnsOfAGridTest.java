package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheWidthOfColumnsOfAGridTest {
    FindTheWidthOfColumnsOfAGrid findTheWidthOfColumnsOfAGrid = new FindTheWidthOfColumnsOfAGrid();

    @Test
    void findColumnWidthV2() {
        int[][] grid = {{1}, {22}, {333}};
        int[] expected = {3};
        int[] actual = findTheWidthOfColumnsOfAGrid.findColumnWidthV2(grid);
        assertArrayEquals(expected, actual);
    }
}