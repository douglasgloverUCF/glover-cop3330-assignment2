package ex34;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Sol34Test {
    Sol34 app = new Sol34();
    @Test
    void addEmployee_adds_to_list() {
        ArrayList<String> list = new ArrayList<>();
        app.addEmployee(list,"Abc");
        assertFalse(list.isEmpty());
    }
    @Test
    void removeEmployee_removes_from_list() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Abc");
        app.removeEmployee(list,"Abc");
        assertTrue(list.isEmpty());
    }
}