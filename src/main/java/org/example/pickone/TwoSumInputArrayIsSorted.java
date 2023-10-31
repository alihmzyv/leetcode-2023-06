package org.example.pickone;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int maxIndexToSearchForComplementaryNumInclusive = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            int num = numbers[i];
            int complementaryNum = target - num;
            int binarySearchResult = Arrays.binarySearch(numbers, i + 1, maxIndexToSearchForComplementaryNumInclusive + 1, complementaryNum);
            if (binarySearchResult < 0) { //binarySearchResult = - (insertion point) - 1
                maxIndexToSearchForComplementaryNumInclusive = - binarySearchResult - 2;
            } else { //found, binarySearchResult = index of complementary
                return new int[]{i + 1, binarySearchResult + 1};
            }
        }
        return new int[]{numbers.length - 2, numbers.length - 1};
    }
}
