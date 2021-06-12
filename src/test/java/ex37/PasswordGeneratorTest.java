package ex37;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {
    PasswordGenerator pass = new PasswordGenerator();
    @RepeatedTest(5)
    void password_is_minimum_length() {
        int minLength = (int) (Math.random() * 20);
        String result = pass.generatePassword(2, 2, minLength);
        assertTrue(result.length() >= minLength);
    }
    @RepeatedTest(5)
    void password_contains_at_least_half_letters() {
        String result = pass.generatePassword(2, 2, 4);
        int letterCount = 0;
        int otherCount = 0;
        for(int i = 0; i < result.length(); i++) {
            if (pass.letters.contains(result.charAt(i)))
                letterCount++;
            else
                otherCount++;
        }
        assertTrue(letterCount >= otherCount);
    }
    @RepeatedTest(5)
    void password_contains_correct_amount_of_specials() {
        int specialCount = (int) (Math.random() * 10);
        String result = pass.generatePassword(specialCount, 2, 10);
        int resultCount = 0;
        for(int i = 0; i < result.length(); i++) {
            if (pass.specials.contains(result.charAt(i)))
                resultCount++;
        }
        assertEquals(resultCount, specialCount);
    }
    @RepeatedTest(5)
    void password_contains_correct_amount_of_numbers() {
        int numberCount = (int) (Math.random() * 10);
        String result = pass.generatePassword(2, numberCount, 10);
        int resultCount = 0;
        for(int i = 0; i < result.length(); i++) {
            if (pass.numbers.contains(result.charAt(i)))
                resultCount++;
        }
        assertEquals(resultCount, numberCount);
    }
}