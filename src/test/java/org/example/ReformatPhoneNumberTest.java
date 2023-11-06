package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReformatPhoneNumberTest {
    private final ReformatPhoneNumber reformatPhoneNumber = new ReformatPhoneNumber();

    @Test
    void reformatNumberTest1() {
        String rawNumber = "1-23-45 6";
        String expectedResult = "123-456";
        String actualResult = reformatPhoneNumber.reformatNumber(rawNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void reformatNumberTest2() {
        String rawNumber = "123 4-567";
        String expectedResult = "123-45-67";
        String actualResult = reformatPhoneNumber.reformatNumber(rawNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void reformatNumberTest3() {
        String rawNumber = "123 4-5678";
        String expectedResult = "123-456-78";
        String actualResult = reformatPhoneNumber.reformatNumber(rawNumber);
        assertEquals(expectedResult, actualResult);
    }
}