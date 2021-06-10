package ex33;

import jdk.jfr.Percentage;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol33Test {
    Sol33 app = new Sol33();
    @Test
    void shake_returns_random_message() {
        boolean[] actual = {false, false, false, false};
        boolean[] expected = {true, true, true, true};
        int[] resultCount = new int[4];
        String message;
        for(int i = 0; i < 100; i++)
        {
            message = app.shake();
            if(message.equals("Yes."))
            {
               actual[0] = true;
               resultCount[0]++;
            }
            if(message.equals("No."))
            {
                actual[1] = true;
                resultCount[1]++;
            }
            if(message.equals("Maybe."))
            {
                actual[2] = true;
                resultCount[2]++;
            }
            if(message.equals("Ask again later."))
            {
                actual[3] = true;
                resultCount[3]++;
            }
        }
        System.out.printf("""
        Yes. = %d
        No. = %d
        Maybe. = %d
        Ask again later. = %d
        """, resultCount[0], resultCount[1], resultCount[2], resultCount[3]);
        assertArrayEquals(actual, expected);
    }
    boolean shake_message() {
        String result = app.shake();
        String expected = "Yes.";
        return result.equals(expected);
    }
}