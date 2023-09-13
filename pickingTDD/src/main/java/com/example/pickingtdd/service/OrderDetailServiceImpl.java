package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public OrderDetail makeOrderDetail(OrderDetail orderDetail) throws Exception {
        return orderDetail;
    }
}
