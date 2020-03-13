package shawn.designpattern.memento;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {

    @Test
    void dateTest() {
        Date d = new Date();
        d.setTime(System.currentTimeMillis());
        d.setTime(System.currentTimeMillis() - 1000);
    }
}
