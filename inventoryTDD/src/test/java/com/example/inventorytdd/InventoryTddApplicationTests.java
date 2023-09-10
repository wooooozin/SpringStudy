package com.example.inventorytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryTddApplicationTests {

    @Test
    void testInventory_size_test() {
        Inventory inventory = new Inventory();

        inventory.setHeight(10);
        inventory.setWidth(10);
        inventory.setLength(10);

        Assertions.assertEquals(10, inventory.getHeight());
        Assertions.assertEquals(10, inventory.getWidth());
        Assertions.assertEquals(10, inventory.getLength());
    }

    @Test
    void testInventory_type_test() {
        //given
        Inventory inventory = new Inventory();

        // when
        inventory.setType(InventoryType.COLD);

        // then
        Assertions.assertEquals(InventoryType.COLD, inventory.getType());

    }

    @Test
    void testInventory_capacity_test() {
        //given
        Inventory inventory = new Inventory();

        // when
        inventory.setCapacity(10);

        // then
        Assertions.assertEquals(10, inventory.getCapacity());
    }
    
    @Test
    void testInventory_current_test() {
        //given
        Inventory inventory = new Inventory();
        
        // when
        inventory.setCurrent(5);

        // then
        Assertions.assertEquals(5, inventory.getCurrent());
    }
}
