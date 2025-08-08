package mockito3;

import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

    @Test
    public void testDivideByZeroThrowsException() {
        Calculator calc = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(10, 0);
        });
    }
}
