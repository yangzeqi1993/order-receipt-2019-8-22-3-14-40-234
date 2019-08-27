package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private double totSalesTax;
    private double totalAmount;
    private Order order;
    private StringBuilder output = new StringBuilder();

    public OrderReceipt(double totSalesTax, double totalAmount, Order order) {
        this.totSalesTax = totSalesTax;
        this.totalAmount = totalAmount;
        this.order = order;
    }

    public String printReceipt() {

        outputOrders();
        outputCustomerName();
        outputCustomerAddress();
        outputAllLineItem();
        outSalesTax();
        outTotalAmount();

        return output.toString();
    }

    private void outputOrders(){
        output.append("======Printing Orders======\n");
    }

    private void outputCustomerName(){
        output.append(order.getCustomerName());
    }

    private void outputCustomerAddress(){
        output.append(order.getCustomerAddress());
    }

    private void outputAllLineItem(){
        // prints lineItems
        for (LineItem lineItem : order.getLineItems()) {
            outputOneLineItem(lineItem);
            totSalesTax += calculateSalesTax(lineItem.getTotalAmount());
            totalAmount += lineItem.getTotalAmount() + calculateSalesTax(lineItem.getTotalAmount());
        }

    }

    private void outputOneLineItem(LineItem lineItem){
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.getTotalAmount());
        output.append('\n');
    }

    private void outSalesTax(){
        output.append("Sales Tax").append('\t').append(totSalesTax);
    }

    private void outTotalAmount(){
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private double calculateSalesTax(double itemPrice){
        double taxRate = 0.10;
        return itemPrice * taxRate;
    }
}
