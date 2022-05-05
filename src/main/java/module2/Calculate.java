package module2;


//please don't forget we are using OOP
//try to implement the application with Java objects like Shop, product, calculator etc.
//also use Mockito for mocking internal dependency

//actually I could apply the HW as done, but in this case, you won't learn using Mockito but it's a very important and useful tool
//so I suggest refactoring it
public class Calculate {
  public double calculateTotalCost(String groceryBasket) {
    double result = 0;
    int discountA = 0;
    int discountC = 0;
    char[] codeArr = groceryBasket.toCharArray();

    for (char currentCode : codeArr) {
      if (currentCode == 'A') {
        result += 1.25;
        discountA++;
      } else if (currentCode == 'B') {
        result += 4.25;
      } else if (currentCode == 'C') {
        result += 1.00;
        discountC++;
      } else if (currentCode == 'D') {
        result += 0.75;
      } else throw new IllegalArgumentException("Incorrect input");
    }

    if (discountA >= 3) {
      result -= 0.75;
    }
    if (discountC >= 6) {
      result -= 1;
    }

    return result;
  }
}
