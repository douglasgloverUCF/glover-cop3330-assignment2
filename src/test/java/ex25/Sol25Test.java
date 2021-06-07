package ex25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sol25Test {
    static Sol25 app = new Sol25();

    @Test
    void returns_0_if_very_weak_password() {

        int result = app.passwordValidator("12345");
        assertEquals(0, result);
    }

    @Test
    void returns_1_if_weak_password() {

        int result = app.passwordValidator("abcdef");
        assertEquals(1, result);
    }

    @Test
    void returns_2_if_strong_password() {

        int result = app.passwordValidator("abc123xyz");
        assertEquals(2, result);
    }

    @Test
    void returns_3_if_very_strong_password() {

        int result = app.passwordValidator("1337h@xor!");
        assertEquals(3, result);
    }
}