package ua.goit.java5.dev.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

//We shouldn't mock the main class what we want to test, we have to mock only internal dependencies
  // it means we have to mock DataBase IN CalculateTest because the Calculate class use the DataBase inside

  //if we want to test DataBase class we have to do it without Mockito
class DataBaseTest {

  @Mock DataBase dataBase;

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
}
