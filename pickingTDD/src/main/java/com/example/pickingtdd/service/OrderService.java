package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;

public interface OrderService {
    Order makeOrder(Order order) throws Exception;
}
