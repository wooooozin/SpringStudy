package com.example.inventorytdd;

import lombok.Data;

@Data
public class Inventory {
    private int length;
    private int width;
    private int height;
    private InventoryType type;
    private int capacity;
    private int current;
}
