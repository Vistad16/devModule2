package ua.goit.java5.dev.module2;

import ua.goit.java5.dev.module2.service.DataBaseService;
import ua.goit.java5.dev.module2.service.HardcodedDataBase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculate {
  DataBaseService dataBase = new HardcodedDataBase();

  public double calculateTotalCost(String groceryBasket) {
    double result = 0;

    char[] codeArr = groceryBasket.toCharArray();

    Map<Character, AtomicInteger> goodCount = new HashMap<>();

    for (char currentCode : codeArr) {
      Goods goods = dataBase.getGoods(currentCode);
      if (goods == null) {
        throw new IllegalArgumentException("Incorrect value");
      }
      int quantity =
          goodCount.computeIfAbsent(currentCode, key -> new AtomicInteger(0)).incrementAndGet();

      result += goods.getPrice();
      if (quantity == goods.getQuantityDiscount()) {

        result = subtractDiscount(result, goods);
      }
    }

    return result;
  }

  private BigDecimal getGoodDiscount(Goods goods) {
    return BigDecimal.valueOf(goods.getDiscountPrice())
        .multiply(BigDecimal.valueOf(goods.getQuantityDiscount()));
  }

  private double subtractDiscount(double totalPrice, Goods goods) {
    BigDecimal goodDiscount = getGoodDiscount(goods);
    return BigDecimal.valueOf(totalPrice).subtract(goodDiscount).doubleValue();
  }
}
