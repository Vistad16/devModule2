package ua.goit.java5.dev.module2;

public class Calculate {
  DataBase dataBase = new DataBase();

  public double calculateTotalCost(String groceryBasket) {
    double result = 0;
    int discountA = 0;
    int discountB = 0;
    int discountC = 0;
    int discountD = 0;
    char[] codeArr = groceryBasket.toCharArray();

    for (char currentCode : codeArr) {
      Goods goods = (Goods) dataBase.goodsBase(currentCode);
      if (currentCode == 'A') {
        result += goods.getPrice();
        discountA++;
      } else if (currentCode == 'B') {
        result += goods.getPrice();
        discountB++;
      } else if (currentCode == 'C') {
        result += goods.getPrice();
        discountC++;
      } else if (currentCode == 'D') {
        result += goods.getPrice();
        discountD++;
      } else throw new IllegalArgumentException("Incorrect input");
    }

    result = discountCheck('A', result, discountA);
    result = discountCheck('B', result, discountB);
    result = discountCheck('C', result, discountC);
    result = discountCheck('D', result, discountD);

    return result;
  }

  private double discountCheck(char id, double result, int discount) {
    Goods goods = (Goods) dataBase.goodsBase(id);
    if (goods.getQuantityDiscount() != 0 & discount >= goods.getQuantityDiscount()) {
      result -= goods.getQuantityDiscount() * goods.getDiscountPrice();
    }
    return result;
  }
}