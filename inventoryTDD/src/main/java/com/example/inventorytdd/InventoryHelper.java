package com.example.inventorytdd;

public class InventoryHelper {
    public boolean inbound(Inventory inventory, int count) {
        if (this.getInboundCapable(inventory, count)) {
            inventory.setCurrent(count);
            return true;
        }
        return false;
    }

    public boolean getInboundCapable(Inventory inventory, int count) {
        return getUsableCapacity(inventory) >= count;
    }

    public int getUsableCapacity(Inventory inventory) {
        return inventory.getCapacity() - inventory.getCurrent();
    }

    public Inventory createInventory() {
        return new Inventory();

    }
}
