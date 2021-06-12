package ex38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol38Test {
    Sol38 app = new Sol38();
    @Test
    void getArray_returns_only_integers() {
        String string = "5 8 32 1 9 6 27 8";
        int[] results = app.getArray(string);
        int[] expected = {5, 8, 32, 1, 9, 6, 27, 8};
        assertArrayEquals(results, expected);
    }
    @Test
    void filterEvenNumbers_returns_all_evens() {
        int[] array = {1, 1, 2, 3, 4, 4};
        int[] results = app.filterEvenNumbers(array);
        int[] expected = {2, 4, 4};
        assertArrayEquals(results, expected);
    }
}