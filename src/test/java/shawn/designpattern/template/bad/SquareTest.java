package shawn.designpattern.template.bad;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void getArea() {
        // GIVEN
        Rectangle rectangle = new Square();
        rectangle.setHeight(5);
        rectangle.setHeight(3);

        // WHEN
        int area = rectangle.getArea();

        // THEN
        assertThat(rectangle.getArea()).isEqualTo(15); // FAIL
    }
}