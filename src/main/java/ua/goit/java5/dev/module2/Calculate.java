package ua.goit.java5.dev.module2;
//please don't forget we are using OOP
//try to implement the application with Java objects like Shop, product, calculator etc.
//also use Mockito for mocking internal dependency

//actually I could apply the HW as done, but in this case, you won't learn using Mockito but it's a very important and useful tool
//so I suggest refactoring it
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
      Goods goods = dataBase.goodsBase(currentCode);
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
    Goods goods = dataBase.goodsBase(id);
    if (goods.getQuantityDiscount() != 0 & discount >= goods.getQuantityDiscount()) {
      result -= goods.getQuantityDiscount() * goods.getDiscountPrice();
    }
    return result;
  }
}