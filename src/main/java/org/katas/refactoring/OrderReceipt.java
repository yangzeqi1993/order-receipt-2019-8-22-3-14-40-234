package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        output.append(outputAllLineItem(output,order));

        return output.toString();
    }

    private StringBuilder outputAllLineItem(StringBuilder output, Order order){
        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(outputOneLineItem(output,lineItem));
            totSalesTx += calculateSalesTax(lineItem.getTotalAmount());
            tot += lineItem.getTotalAmount() + calculateSalesTax(lineItem.getTotalAmount());
        }

        output.append(outSalesTax(output,totSalesTx));
        output.append(outSalesTax(output,tot));
        return output;
    }

    private StringBuilder outSalesTax(StringBuilder output, double totSalesTx){
        return output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private StringBuilder outTotalAmount(StringBuilder output, double tot){
        return output.append("Total Amount").append('\t').append(tot);
    }

    private StringBuilder outputOneLineItem(StringBuilder output, LineItem lineItem){
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.getTotalAmount());
        output.append('\n');
        return output;
    }

    private double calculateSalesTax(double itemPrice){
        double taxRate = 0.10;
        return itemPrice * taxRate;
    }
}
