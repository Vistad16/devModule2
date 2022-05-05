package ua.goit.java5.dev.module2;

import lombok.Data;

@Data
public class Goods {
  private double price;
  private int quantityDiscount;
  private double discountPrice;

  public Goods(double price, int quantityDiscount, double discountPrice) {
    this.price = price;
    this.quantityDiscount = quantityDiscount;
    this.discountPrice = discountPrice;
  }
}
