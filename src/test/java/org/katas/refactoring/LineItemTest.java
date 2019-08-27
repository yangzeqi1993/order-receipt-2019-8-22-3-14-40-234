package org.katas.refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineItemTest {
    @Test
    public void should_get_total_money_is_50_when_getTotalAmount_by_given_price_is_10_and_quantity_is_5(){
        //given
        String describe = "test";
        double price = 10.0;
        int quantity = 5;
        LineItem lineItem = new LineItem(describe,price,quantity);

        //when
        double total = lineItem.getTotalAmount();
        //then
        assertEquals(50,total);
    }
}
