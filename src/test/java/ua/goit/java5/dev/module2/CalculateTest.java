package ua.goit.java5.dev.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CalculateTest {

  @ExtendWith(MockitoExtension.class)
  @Mock
  DataBase dataBase;

  //Very-very close
  //the last step: in the testThatDataBaseWithIdA you mocked the call to dataBase object and then asserts the same
  //we shouldn't test the mockito, we have to test the Calculate class

  //For example testThatCalculateTotalCostForDifferentValues
  //you have to you have to Mock all calls to the dataBase during the calculateTotalCost method in the same test

  // to summarise - we have to test Calculate class but in the test we have to mock DataBase usages inside the method

  //it can be difficult. It's because you code structure. Code should be testable, maybe it's will be better refactoring it a little

  @Test
  public void testThatDataBaseWithIdA() {
    when(dataBase.getGoods('A')).thenReturn(new DataBase().getGoods('A'));

    assertEquals(new DataBase().getGoods('A'), dataBase.getGoods('A'));
    assertEquals(new DataBase().getGoods('A').getPrice(), dataBase.getGoods('A').getPrice());
    assertEquals(
        new DataBase().getGoods('A').getQuantityDiscount(),
        dataBase.getGoods('A').getQuantityDiscount());
    assertEquals(
        new DataBase().getGoods('A').getDiscountPrice(), dataBase.getGoods('A').getDiscountPrice());
  }

  @Test
  public void testThatDataBaseWithIdB() {
    when(dataBase.getGoods('B')).thenReturn(new DataBase().getGoods('B'));

    assertEquals(new DataBase().getGoods('B'), dataBase.getGoods('B'));
    assertEquals(new DataBase().getGoods('B').getPrice(), dataBase.getGoods('B').getPrice());
    assertEquals(
        new DataBase().getGoods('B').getQuantityDiscount(),
        dataBase.getGoods('B').getQuantityDiscount());
    assertEquals(
        new DataBase().getGoods('B').getDiscountPrice(), dataBase.getGoods('B').getDiscountPrice());
  }

  @Test
  public void testThatDataBaseWithIdC() {
    when(dataBase.getGoods('C')).thenReturn(new DataBase().getGoods('C'));

    assertEquals(new DataBase().getGoods('C'), dataBase.getGoods('C'));
    assertEquals(new DataBase().getGoods('C').getPrice(), dataBase.getGoods('C').getPrice());
    assertEquals(
        new DataBase().getGoods('C').getQuantityDiscount(),
        dataBase.getGoods('C').getQuantityDiscount());
    assertEquals(
        new DataBase().getGoods('C').getDiscountPrice(), dataBase.getGoods('C').getDiscountPrice());
  }

  @Test
  public void testThatDataBaseWithIdD() {
    when(dataBase.getGoods('D')).thenReturn(new DataBase().getGoods('D'));

    assertEquals(new DataBase().getGoods('D'), dataBase.getGoods('D'));
    assertEquals(new DataBase().getGoods('D').getPrice(), dataBase.getGoods('D').getPrice());
    assertEquals(
        new DataBase().getGoods('D').getQuantityDiscount(),
        dataBase.getGoods('D').getQuantityDiscount());
    assertEquals(
        new DataBase().getGoods('D').getDiscountPrice(), dataBase.getGoods('D').getDiscountPrice());
  }

  @Test
  public void testThatCalculateTotalCostForEmptyValues() {
    double actual = new Calculate().calculateTotalCost("");
    double expected = 0.0;

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
        (code, price) -> assertEquals(price, new Calculate().calculateTotalCost(code), code));
  }

  @Test
  public void testThatCalculateTotalCostForDifferentValues() {
    double actual = new Calculate().calculateTotalCost("ABCD");
    double expected = 7.25;

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostForDiscountA() {
    double actual = new Calculate().calculateTotalCost("AAA");
    double expected = 3.00;

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostForDiscountC() {
    double actual = new Calculate().calculateTotalCost("CCCCCC");
    double expected = 5.00;

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostMaxCases() {
    double actual = new Calculate().calculateTotalCost("CACBCACACDCAC");
    double expected = 15.25;

    assertEquals(expected, actual);
  }

  @Test
  public void testThatCalculateTotalCostThrowsIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> new Calculate().calculateTotalCost("CACBCA CACDCAC"));
  }

  @Test
  public void testThatCalculateTotalCostThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> new Calculate().calculateTotalCost(null));
  }
}
