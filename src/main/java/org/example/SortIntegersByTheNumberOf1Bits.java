package org.example;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(IntegerComparableWrapper::ofVal)
                .sorted()
                .map(IntegerComparableWrapper::val)
                .mapToInt(num -> num)
                .toArray();
    }

    private static String toBinary(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int k = num >> i;
            if ((k & 1) > 0)
                result.append("1");
            else
                result.append("0");
        }
        return result.toString();
    }

    private record IntegerComparableWrapper(int val) implements Comparable<IntegerComparableWrapper> {
        private static IntegerComparableWrapper ofVal(int val) {
            return new IntegerComparableWrapper(val);
        }

        @Override
        public int compareTo(IntegerComparableWrapper that) {
            String binaryRepOfThis = toBinary(this.val);
            String binaryRepOfThat = toBinary(that.val);
            int zerosInThis = countOccurrencesOfOne(binaryRepOfThis);
            int zerosInThat = countOccurrencesOfOne(binaryRepOfThat);
            int comparisonByZerosInBinary = Integer.compare(zerosInThis, zerosInThat);
            if (comparisonByZerosInBinary == 0) {
                return Integer.compare(this.val, that.val);
            }
            return comparisonByZerosInBinary;
        }

        private static int countOccurrencesOfOne(String str) {
            return str.length() - str.replace("1", "").length();
        }

        @Override
        public String toString() {
            return "IntegerComparableWrapper{" +
                    "val=" + val + ", " +
                    "binary=" + toBinary(val) +
                    '}';
        }
    }
}
