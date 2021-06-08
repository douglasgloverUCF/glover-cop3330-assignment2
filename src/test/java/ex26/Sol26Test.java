package ex26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol26Test {
    static Sol26 app = new Sol26();
    @Test
    void calculateMonthsUntilPaidOff() {
        int result = app.calculateMonthsUntilPaidOff(5000, 12, 100);
        assertEquals(70, result);
    }
}