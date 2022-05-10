package ua.goit.java5.dev.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataBaseTest {

  @Mock DataBase dataBase;

  @Test
  public void testThatDataBaseWithIdA() {
    when(dataBase.getGoods('A')).thenReturn(new DataBase().getGoods('A'));

    assertEquals(new DataBase().getGoods('A').getPrice(), dataBase.getGoods('A').getPrice());
  }

  @Test
  public void testThatDataBaseWithIdB() {
    when(dataBase.getGoods('B')).thenReturn(new DataBase().getGoods('B'));

    assertEquals(new DataBase().getGoods('B').getPrice(), dataBase.getGoods('B').getPrice());
  }

  @Test
  public void testThatDataBaseWithIdC() {
    when(dataBase.getGoods('C')).thenReturn(new DataBase().getGoods('C'));

    assertEquals(new DataBase().getGoods('C').getPrice(), dataBase.getGoods('C').getPrice());
  }

  @Test
  public void testThatDataBaseWithIdD() {
    when(dataBase.getGoods('D')).thenReturn(new DataBase().getGoods('D'));

    assertEquals(new DataBase().getGoods('D').getPrice(), dataBase.getGoods('D').getPrice());
  }
}
