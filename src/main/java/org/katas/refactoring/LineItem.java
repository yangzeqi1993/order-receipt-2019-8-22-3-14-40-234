package org.katas.refactoring;

public class LineItem {
    private String describe;
    private double price;
    private int quantity;

    public LineItem(String describe, double price, int quantity) {
        this.describe = describe;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return describe;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double getTotalAmount() {
        return price * quantity;
    }
}
