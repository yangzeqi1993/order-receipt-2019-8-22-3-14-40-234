package org.katas.refactoring;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static javafx.beans.binding.Bindings.when;
import static org.assertj.core.api.Assertions.assertThat;


class OrderReceiptTest {

//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @Before
//    void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @After
//    void restoreStreams() {
//        System.setOut(originalOut);
//    }

    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(0d,0d, order);

        String output = receipt.printReceipt();

        assertThat(output).contains("Mr X", "Chicago, 60601");
    }

    @Test
    void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(0d,0d,new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

//    @Test
//    public void should_print_all_line_items_when_use_outputAllLineItem_method_by_given_totSalesTax_and_totalAmount_and_order(){
//        // given
//        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
//            add(new LineItem("milk", 10.0, 2));
//            add(new LineItem("biscuits", 5.0, 5));
//            add(new LineItem("chocolate", 20.0, 1));
//        }};
//        OrderReceipt receipt = new OrderReceipt(0d,0d,new Order(null, null, lineItems));
//        when(receipt.outputAllLineItem())
//
//
//        // when
//        System.out.println(); receipt.outputAllLineItem();
//    }

}
