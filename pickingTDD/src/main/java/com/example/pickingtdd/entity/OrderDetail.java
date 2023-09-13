package com.example.pickingtdd.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private long orderDetailId;
    private long orderId;
    private Sku sku;
    private int amount;
}
