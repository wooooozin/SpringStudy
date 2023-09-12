package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public Order makeOrder(Order order) throws Exception {
        if (orderMakeValidation(order)) {
            // order 생성
            return order;
        } else {
            throw new Exception("order validation fail");
        }
    }

    private boolean orderMakeValidation(Order order) {
        if (order.getOrderId() == null) {
            return false;
        }
        if (order.getState() == null) {
            return false;
        }
        return true;
    }
}
