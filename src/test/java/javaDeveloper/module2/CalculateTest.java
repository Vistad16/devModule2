package javaDeveloper.module2;

import module2.Calculate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateTest {

    @Test
    public void testThatCalculateTotalCostForEmptyValues() {
        double actual = new Calculate().calculateTotalCost("");
        double expected = 0.0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostWorksOk() {
        Map<String, Double> testCase = new HashMap<>();
        testCase.put("A", 1.25);
        testCase.put("B", 4.25);
        testCase.put("C", 1.00);
        testCase.put("D", 0.75);

        testCase.forEach((code, price) ->
                Assertions.assertEquals(price, new Calculate().calculateTotalCost(code), code));

    }

    @Test
    public void testThatCalculateTotalCostForDifferentValues() {
        double actual = new Calculate().calculateTotalCost("ABCD");
        double expected = 7.25;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostForDiscountA() {
        double actual = new Calculate().calculateTotalCost("AAA");
        double expected = 3.00;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostForDiscountC() {
        double actual = new Calculate().calculateTotalCost("CCCCCC");
        double expected = 5.00;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostMaxCases() {
        double actual = new Calculate().calculateTotalCost("CACBCACACDCAC");
        double expected = 15.25;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatCalculateTotalCostThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Calculate().calculateTotalCost("CACBCA CACDCAC");
        });
    }

}