package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderDetailService orderDetailService;

    @Override
    public Order makeOrder(Order order) throws Exception {
        if (orderMakeValidation(order)) {
            // order 생성
            for (OrderDetail orderDetail : order.getOrderDetailList()) {
                try {
                    orderDetailService.makeOrderDetail(orderDetail);
                } catch (Exception e) {
                    throw e;
                }
            }
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
        if (order.getOrderDetailList() == null ||
        order.getOrderDetailList().size() < 1) {
            return false;
        }
        return true;
    }
}
