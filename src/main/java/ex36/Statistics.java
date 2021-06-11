package ex36;

import java.util.ArrayList;

public class Statistics {
    double average(ArrayList<Integer> numbers)
    {
        double average;
        double sum = 0;
        double size = numbers.size();
        for (Integer number : numbers) {
            sum += number;
        }
        average = sum / size;
        return average;
    }
    int min(ArrayList<Integer> numbers)
    {
        int min = numbers.get(0);
        for (Integer number : numbers) {
            if (min > number)
                min = number;
        }
        return min;
    }
    int max(ArrayList<Integer> numbers)
    {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number)
                max = number;
        }
        return max;
    }
    double std(ArrayList<Integer> numbers)
    {
        double average = this.average(numbers);
        double size = numbers.size();
        double std = 0;
        for (Integer number : numbers) {
            std += Math.pow(number - average, 2);
        }
        std = Math.sqrt(std / size);
        return std;
    }
}
