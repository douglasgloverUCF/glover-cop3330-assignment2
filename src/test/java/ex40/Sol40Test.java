package ex40;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Sol40Test {
    Sol40 app = new Sol40();
    @Test
    void getSearchData() {
        List<Map<Integer, String>> data = app.getData();
        List<Map<Integer, String>> results = app.getSearchData(data, "Jac");
        assertEquals("Jacquelyn", results.get(0).get(0));
    }
}