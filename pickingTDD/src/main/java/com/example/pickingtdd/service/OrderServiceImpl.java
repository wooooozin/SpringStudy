package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order makeOrder(Order order) {
        return order;
    }
}
