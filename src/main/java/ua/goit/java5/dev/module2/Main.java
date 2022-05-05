package ua.goit.java5.dev.module2;

public class Main {
  public static void main(String[] args) {
    double test = new Calculate().calculateTotalCost("ABCDABA"); // expected 13.25
    System.out.println("Total price = " + test);
  }
}
