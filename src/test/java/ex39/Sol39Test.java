package ex39;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Sol39Test {
    Sol39 app = new Sol39();
    @Test
    void getPersonMap_returns_map_with_data_correct() {
        Map<Integer, String> results = app.getPersonMap("Jacquelyn", "Jackson", "DBA", "");
        assertEquals(results.get(0), "Jacquelyn");
    }
}