package ex29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol29Test {
    Sol29 app = new Sol29();
    @Test
    void returns_0_if_invalid() {
        String input = "ABC";
        double result = app.validateInput(input);
        assertEquals(0, result);
    }
    @Test
    void returns_0_if_invalid_with_numbers() {
        String input = "ABC123";
        double result = app.validateInput(input);
        assertEquals(0, result);
    }
    @Test
    void returns_0_if_0() {
        String input = "0";
        double result = app.validateInput(input);
        assertEquals(0, result);
    }
    @Test
    void returns_value_if_valid() {
        String input = "4";
        double result = app.validateInput(input);
        assertEquals(4, result);
    }
}