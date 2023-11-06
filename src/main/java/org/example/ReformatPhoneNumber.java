package org.example;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReformatPhoneNumber {
    private static final String SPACE_OR_DASH_REGEX = "\\s|-";
    private static final String EMPTY_STR = "";
    private static final String DELIMITER = "-";

    public String reformatNumber(String number) {
        String cleanNumber = clean(number);
        List<String> tripleParts = getAsTripleParts(cleanNumber);
        List<String> doubleParts = getAsDoublePartsIfAnyLeft(tripleParts, cleanNumber);
        tripleParts.addAll(doubleParts);
        return joinAllParts(tripleParts);
    }

    private String clean(String number) {
        return number.replaceAll(SPACE_OR_DASH_REGEX, EMPTY_STR);
    }

    private List<String> getAsTripleParts(String cleanNumber) {
        int lastTripleDivisionIndex = getLastTripleDivisionIndex(cleanNumber);
        AtomicInteger tripleDivisionIndexHolder = new AtomicInteger();
        return Stream.iterate(tripleDivisionIndexHolder.get(), tripleDivisionIndex -> tripleDivisionIndex <= lastTripleDivisionIndex, tripleDivisionIndex -> tripleDivisionIndexHolder.addAndGet(3))
                .map(index -> cleanNumber.substring(index, index + 3))
                .collect(Collectors.toList());
    }

    private int getLastTripleDivisionIndex(String cleanNumber) {
        if (cleanNumber.length() % 3 == 1) {
            return cleanNumber.length() - 7;
        } else if (cleanNumber.length() % 3 == 0) {
            return cleanNumber.length() - 3;
        } else {
            return cleanNumber.length() - 5;
        }
    }

    private List<String> getAsDoublePartsIfAnyLeft(List<String> tripleParts, String cleanNumber) {
        int doubleDivisionStartingIndex = getDoubleDivisionStartingIndex(tripleParts);
        return getAsDoubleParts(doubleDivisionStartingIndex, cleanNumber);
    }

    private int getDoubleDivisionStartingIndex(List<String> tripleParts) {
        return tripleParts.size() * 3;
    }

    private String joinAllParts(List<String> allParts) {
        return String.join(DELIMITER, allParts);
    }

    private List<String> getAsDoubleParts(int doubleDivisionStartingIndex, String cleanNumber) {
        int lastDoubleDivisionIndex = getLastDoubleDivisionIndex(cleanNumber);
        return Stream.iterate(doubleDivisionStartingIndex, doubleDivisionIndex -> doubleDivisionIndex <= lastDoubleDivisionIndex, doubleDivisionIndex -> doubleDivisionIndex + 2)
                .map(i -> cleanNumber.substring(i, i + 2))
                .collect(Collectors.toList());
    }

    private int getLastDoubleDivisionIndex(String cleanNumber) {
        return cleanNumber.length() - 2;
    }
}
