package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidthV1(int[][] grid) {
        //col = columns
        int gridWidth = grid[0].length;
        int[] colWidths = new int[gridWidth];
        
        for (int colIndex = 0; colIndex < gridWidth; colIndex++) {
            int colWidth = findColWidthByColIndexV1(colIndex, grid);
            colWidths[colIndex] = colWidth;
        }
        return colWidths;
    }

    private int findColWidthByColIndexV1(int colIndex, int[][] grid) {
        int colWidth = Integer.MIN_VALUE;
        for (int[] row : grid) {
            int colVal = row[colIndex];
            int len = getLength(colVal);
            if (len > colWidth) {
                colWidth = len;
            }
        }
        return colWidth;
    }
    
    public int[] findColumnWidthV2(int[][] grid) {
        int gridWidth = grid[0].length;
        return IntStream.range(0, gridWidth)
                .map(colIndex -> findColWidthByColIndexV2(colIndex, grid))
                .toArray();
    }

    private int findColWidthByColIndexV2(int colIndex, int[][] grid) {
        final int[] colWidth = {Integer.MIN_VALUE};
        Arrays.stream(grid)
                .forEach(row -> {
                    int colVal = row[colIndex];
                    int colValLen = getLength(colVal);
                    if (colValLen > colWidth[0]) {
                        colWidth[0] = colValLen;
                    }
                });
        return colWidth[0];
    }

    private int getLength(int num) { //can be moved to util
        return String.valueOf(num).length();
    }
}
