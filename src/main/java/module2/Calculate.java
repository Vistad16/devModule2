package module2;

public class Calculate {
    public double calculateTotalCost(String groceryBasket){
        double result = 0;
        double discountA = 0;
        double discountC = 0;
        char[] codeArr = groceryBasket.toCharArray();

        for (int i = 0; i < codeArr.length; i++) {
            char currentCode = codeArr[i];

            if (currentCode == 'A') {
                result += 1.25;
                discountA += 0.25;
            } else if (currentCode == 'B') {
                result += 4.25;
            } else if (currentCode == 'C') {
                result += 1.00;
                discountC += 0.1666666666666667;
            } else if (currentCode == 'D') {
                result += 0.75;
            } else
                throw new IllegalArgumentException("Incorrect input");
        }

        if (discountA >= 0.75) {result -=  discountA;}
        if (discountC >= 1.0) {result -= discountC;}

        return result;

    }
}
