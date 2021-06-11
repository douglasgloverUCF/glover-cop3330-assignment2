package ex36;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    Statistics stats = new Statistics();
    @Test
    void average_returns_correct_value() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(1000);
        numbers.add(300);
        double result = stats.average(numbers);
        assertEquals(result, 400.0);
    }

    @Test
    void min_returns_correct_value() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(1000);
        numbers.add(300);
        int result = stats.min(numbers);
        assertEquals(result, 100);
    }

    @Test
    void max_returns_correct_value() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(1000);
        numbers.add(300);
        int result = stats.max(numbers);
        assertEquals(result, 1000);
    }

    @Test
    void std_returns_correct_value() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(1000);
        numbers.add(300);
        double result = stats.std(numbers);
        assertEquals(result, 353.55); //close enough
    }
}