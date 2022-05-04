package module2;

public class Main {
    public static void main(String[] args) {
        double test = new Calculate().calculateTotalCost("ABCDABA");// expected 13.25
        System.out.println(test);
    }
}
