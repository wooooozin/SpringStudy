package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.OrderDetail;
import com.example.pickingtdd.entity.Sku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderDetailServiceTest {

    @Autowired
    OrderDetailService orderDetailService;

    @Test
    void testOrderDetailMake_success() {
        //given
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1L);
        orderDetail.setOrderDetailId(1L);
        orderDetail.setSku(new Sku());
        orderDetail.setAmount(10);

        try {
            orderDetail = orderDetailService.makeOrderDetail(orderDetail);
        } catch (Exception e) {

        }
        // then
        Assertions.assertEquals(1L, orderDetail.getOrderDetailId());
        Assertions.assertEquals(1L, orderDetail.getOrderId());
        Assertions.assertEquals(10, orderDetail.getAmount());
    }

    @Test
    void orderDetailValidationTest() {
        //given

        // when

        // then
    }
}
