package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumIndexSumOfTwoListsTest {
    MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();

    @Test
    void findRestaurant() {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] expectedResult = {"Shogun"};
        String[] actualResult = minimumIndexSumOfTwoLists.findRestaurant(list1, list2);
        assertArrayEquals(expectedResult, actualResult);
    }
}