package ex32;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static final Game app = new Game();
    @RepeatedTest(10)
    void generateRandomValue_within_limits()
    {
        int cap = 10;
        int value = app.generateRandomValue(cap);
        assertTrue(value <= cap && value >= 1);
    }
    @Test
    void guessTest_returns_false_for_invalid() {
        boolean result = app.guessTest(500, -1);
        assertFalse(result);
    }
    @Test
    void guessTest_returns_false_for_low() {
        boolean result = app.guessTest(500, 300);
        assertFalse(result);
    }
    @Test
    void guessTest_returns_false_for_high() {
        boolean result = app.guessTest(500, 700);
        assertFalse(result);
    }
    @Test
    void guessTest_returns_true_for_target() {
        boolean result = app.guessTest(500, 500);
        assertTrue(result);
    }
}