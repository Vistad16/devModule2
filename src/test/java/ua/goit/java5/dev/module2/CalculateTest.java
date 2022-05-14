package ua.goit.java5.dev.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculateTest {

  @InjectMocks Calculate calculate;

  // Very-very close
  // the last step: in the testThatDataBaseWithIdA you mocked the call to dataBase object and then
  // asserts the same
  // we shouldn't test the mockito, we have to test the Calculate class

  // For example testThatCalculateTotalCostForDifferentValues
  // you have to you have to Mock all calls to the dataBase during the calculateTotalCost method in
  // the same test

  // to summarise - we have to test Calculate class but in the test we have to mock DataBase usages
  // inside the method

  // it can be difficult. It's because you code structure. Code should be testable, maybe it's will
  // be better refactoring it a little

  @Test
  public void testThatCalculateTotalCostForEmptyValues() {
    double expected = 0.0;
    double actual = calculate.calculateTotalCost("");

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostWorksOk() {
    Map<String, Double> testCase = new HashMap<>();
    testCase.put("A", 1.25);
    testCase.put("B", 4.25);
    testCase.put("C", 1.00);
    testCase.put("D", 0.75);

    testCase.forEach(
        (code, price) -> assertEquals(price, calculate.calculateTotalCost(code), code));
  }

  @Test
  public void testThatCalculateTotalCostForDifferentValues() {
    double expected = 7.25;
    double actual = calculate.calculateTotalCost("ABCD");

    assertEquals(expected, actual, "Invalid: ABCD");
  }

  @Test
  public void testThatCalculateTotalCostForDiscountA() {
    double expected = 3.00;
    double actual = calculate.calculateTotalCost("AAA");

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostForDiscountC() {
    double expected = 5.00;
    double actual = calculate.calculateTotalCost("CCCCCC");

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostMaxCases() {
    double expected = 15.25;
    double actual = calculate.calculateTotalCost("CACBCACACDCAC");

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostThrowsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> calculate.calculateTotalCost("CACBCA CACDCAC"));
  }

  @Test
  public void testThatCalculateTotalCostThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> calculate.calculateTotalCost(null));
  }
}
