package ua.goit.java5.dev.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.goit.java5.dev.module2.service.HardcodedDataBase;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateTest {

  @InjectMocks Calculate calculate;

  @Mock HardcodedDataBase dataBase;

  @Test
  public void testThatCalculateTotalCostWithMockitoForA() {
    when(dataBase.getGoods('A')).thenReturn(new Goods(1.25, 3, 0.25));
    double expected = 1.25;
    double actual = calculate.calculateTotalCost("A");

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostForEmptyValues() {
    double expected = 0.0;
    double actual = calculate.calculateTotalCost("");

    assertEquals(expected, actual, "EmptyValuesTest");
  }

  @Test
  public void testThatCalculateTotalCostWorksOk() {
    when(dataBase.getGoods('A')).thenReturn(new Goods(1.25, 3, 0.25));
    when(dataBase.getGoods('B')).thenReturn(new Goods(4.25, 0, 0.00));
    when(dataBase.getGoods('C')).thenReturn(new Goods(1.00, 6, 0.1666666666666666666667));
    when(dataBase.getGoods('D')).thenReturn(new Goods(0.75, 0, 0.00));

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
    when(dataBase.getGoods('A')).thenReturn(new Goods(1.25, 3, 0.25));
    when(dataBase.getGoods('B')).thenReturn(new Goods(4.25, 0, 0.00));
    when(dataBase.getGoods('C')).thenReturn(new Goods(1.00, 6, 0.1666666666666666666667));
    when(dataBase.getGoods('D')).thenReturn(new Goods(0.75, 0, 0.00));
    double expected = 7.25;
    double actual = calculate.calculateTotalCost("ABCD");

    assertEquals(expected, actual, "ABCD");
  }

  @Test
  public void testThatCalculateTotalCostForDiscountA() {
    when(dataBase.getGoods('A')).thenReturn(new Goods(1.25, 3, 0.25));
    double expected = 3.00;
    double actual = calculate.calculateTotalCost("AAA");

    assertEquals(expected, actual, "AAA");
  }

  @Test
  public void testThatCalculateTotalCostForDiscountC() {
    when(dataBase.getGoods('C')).thenReturn(new Goods(1.00, 6, 0.1666666666666666666667));
    double expected = 5.00;
    double actual = calculate.calculateTotalCost("CCCCCC");

    assertEquals(expected, actual, "CCCCCC");
  }

  @Test
  public void testThatCalculateTotalCostMaxCases() {
    when(dataBase.getGoods('A')).thenReturn(new Goods(1.25, 3, 0.25));
    when(dataBase.getGoods('B')).thenReturn(new Goods(4.25, 0, 0.00));
    when(dataBase.getGoods('C')).thenReturn(new Goods(1.00, 6, 0.1666666666666666666667));
    when(dataBase.getGoods('D')).thenReturn(new Goods(0.75, 0, 0.00));
    double expected = 15.25;
    double actual = calculate.calculateTotalCost("CACBCACACDCAC");

    assertEquals(expected, actual, "CACBCACACDCAC");
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
