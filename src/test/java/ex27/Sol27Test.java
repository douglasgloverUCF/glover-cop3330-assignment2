package ex27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol27Test {
    Sol27 app = new Sol27();
    @Test
    void returns_no_errors() {
        String result = app.validateInput("Jimmy", "James", "55555", "TK-421");
        assertEquals("There were no errors found.", result);
    }
    @Test
    void returns_errors() {
        String result = app.validateInput("J", "", "ABCDE", "A12-1234");
        assertEquals("""
        "J" is not a valid first name. It is too short.
        The last name must be filled in.
        The ZIP code must be numeric.
        A12-1234 is not a valid ID.
        """, result);
    }
}