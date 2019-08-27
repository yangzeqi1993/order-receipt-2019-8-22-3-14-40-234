package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

    public Order(String customerName, String addr, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = addr;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }



}
