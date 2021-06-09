package ex31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {
    Formula formula = new Formula();
    @Test
    void getTargetRate() {
        int result = formula.getTargetRate(55, 22, 65);
        assertEquals(138, result);
    }
}