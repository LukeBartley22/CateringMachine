package com.techelevator.view;


import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {
    @Test

    public void verifies_item_price_returns_boolean() {
        Inventory inventoryTest = new Inventory();
        double actual = inventoryTest.getItemPrice("A1");
        Assert.assertEquals(3.85, actual, 0);

    }

    @Test
    public void verifies_inventory_stock_true() {
        Inventory inventoryTest = new Inventory();
        boolean actual = inventoryTest.checkInventory("D4");
        Assert.assertTrue(actual);
    }


}
