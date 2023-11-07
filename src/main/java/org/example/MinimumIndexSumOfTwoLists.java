package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MinimumIndexSumOfTwoLists {
    private final List<String> commonsWordsWithLeastIndexSum = new LinkedList<>();
    private final AtomicInteger currLeastIndexSum = new AtomicInteger(Integer.MAX_VALUE);

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> strByIndexForList1 = getStrByIndex(list1);
        return getCommonStrsWithLeastIndexSum(strByIndexForList1, list2);
    }

    private Map<String, Integer> getStrByIndex(String[] list1) {
        Map<String, Integer> strByIndexInList = new HashMap<>(list1.length);
        for (int index = 0; index < list1.length; index++) {
            strByIndexInList.put(list1[index], index);
        }
        return strByIndexInList;
    }

    private String[] getCommonStrsWithLeastIndexSum(Map<String, Integer> strByIndexForList1, String[] list2) {
        for (int index = 0; index < list2.length; index++) {
            String wordToCheck = list2[index];
            Integer indexOfWordToCheckInList1 = strByIndexForList1.get(list2[index]);
            if (indexOfWordToCheckInList1 != null) { //did not use optional for cleaner code
                int indexSumToCheck = indexOfWordToCheckInList1 + index;
                if (indexSumToCheck < getCurrLeastIndexSum()) {
                    setCurrLeastIndexSum(indexSumToCheck);
                    clearCommonsWithLeastIndexSum();
                    addToCommonsWithLeastIndexSum(wordToCheck);
                } else if (indexSumToCheck == getCurrLeastIndexSum()){
                    addToCommonsWithLeastIndexSum(wordToCheck);
                }
            }
        }

        return commonsWordsWithLeastIndexSum.toArray(String[]::new);
    }

    private int getCurrLeastIndexSum() {
        return currLeastIndexSum.get();
    }

    private void setCurrLeastIndexSum(int indexSum) {
        currLeastIndexSum.set(indexSum);
    }

    private void clearCommonsWithLeastIndexSum() {
        commonsWordsWithLeastIndexSum.clear();
    }

    private void addToCommonsWithLeastIndexSum(String word) {
        commonsWordsWithLeastIndexSum.add(word);
    }
}
