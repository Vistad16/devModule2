package ua.goit.java5.dev.module2.service;

import ua.goit.java5.dev.module2.Goods;

import java.util.HashMap;
import java.util.Map;

public class HardcodedDataBase implements DataBaseService {

  @Override
  public Goods getGoods(char id) {
    Map<Character, Goods> objectMap = new HashMap<>();
    objectMap.put('A', new Goods(1.25, 3, 0.25));
    objectMap.put('B', new Goods(4.25, 0, 0.00));
    objectMap.put('C', new Goods(1.00, 6, 0.1666666666666666666667));
    objectMap.put('D', new Goods(0.75, 0, 0.00));

    return objectMap.get(id);
  }
}
