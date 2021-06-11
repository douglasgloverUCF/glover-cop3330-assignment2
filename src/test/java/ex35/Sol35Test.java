package ex35;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Sol35Test {
    Sol35 app = new Sol35();

    @Test
    void pickWinner_returns_name() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Winner");
        String name = app.pickWinner(nameList);
        assertEquals(name, "Winner");
    }
}