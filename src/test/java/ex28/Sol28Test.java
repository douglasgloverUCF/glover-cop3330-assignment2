package ex28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol28Test {
    static Sol28 app = new Sol28();
    @Test
    void returns_calculated_sum() {
        int[] values = {1, 2, 3, 4 ,5};
        int valueCount = 5;
        int result = app.calcTotal(values, valueCount);
        assertEquals(result, 15);
    }
}