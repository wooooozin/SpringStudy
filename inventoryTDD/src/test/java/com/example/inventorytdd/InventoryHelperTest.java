package com.example.inventorytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryHelperTest {

    @Test
    void testInventoryHelper_capacity_good() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        // when
        inventory.setCapacity(10);
        inventory.setCurrent(5);
        int usableCapacity = inventoryHelper.getUsableCapacity(inventory);

        // then
        Assertions.assertEquals(5, usableCapacity);
    }

    @Test
    void testInventoryHelper_inbound_true() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        // when

        inventory.setCapacity(40);
        inventoryHelper.inbound(inventory, 10);

        // then
        Assertions.assertTrue(inventoryHelper.inbound(inventory, 10));
        Assertions.assertEquals(10, inventory.getCurrent());
    }

    @Test
    void testInventoryHelper_inbound_false() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        // when

        inventory.setCapacity(10);

        // then
        Assertions.assertFalse(inventoryHelper.inbound(inventory, 30));
        Assertions.assertEquals(0, inventory.getCurrent());
    }

    @Test
    void testInventoryHelper_getInboundCapable_true() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        // when
        inventory.setCapacity(10);
        inventory.setCurrent(5);

        // then
        Assertions.assertTrue(inventoryHelper.getInboundCapable(inventory, 3));
    }

    @Test
    void testInventoryHelper_getInboundCapable_false() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = new Inventory();

        // when
        inventory.setCapacity(10);
        inventory.setCurrent(5);

        // then
        Assertions.assertFalse(inventoryHelper.getInboundCapable(inventory, 10));
    }

    @Test
    void testInventoryHelper_newInventory() {
        //given
        InventoryHelper inventoryHelper = new InventoryHelper();
        Inventory inventory = inventoryHelper.createInventory();

        // when
        
        // then
        Assertions.assertTrue(inventory instanceof Inventory);
    }

}