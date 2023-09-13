package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.OrderDetail;
import com.example.pickingtdd.entity.Sku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class OrderDetailServiceTest {

    @Autowired
    OrderDetailService orderDetailService;

    OrderDetail orderDetailSuccess;
    OrderDetail orderDetailFail;

    @BeforeEach
    public void setup() {
        orderDetailSuccess = new OrderDetail();
        orderDetailSuccess.setOrderId(1L);
        orderDetailSuccess.setOrderDetailId(1L);
        orderDetailSuccess.setSku(new Sku());
        orderDetailSuccess.setAmount(10);

        orderDetailFail = new OrderDetail();
    }


    @Test
    void testOrderDetailMake_success() {
        //given
        OrderDetail orderDetail = new OrderDetail();

        try {
            orderDetail = orderDetailService.makeOrderDetail(orderDetailSuccess);
        } catch (Exception e) {

        }
        // then
        Assertions.assertEquals(1L, orderDetail.getOrderDetailId());
        Assertions.assertEquals(1L, orderDetail.getOrderId());
        Assertions.assertEquals(10, orderDetail.getAmount());
    }

    @Test
    void testOrderDetailValidation_success() {
        OrderDetail orderDetail = new OrderDetail();

        try {
            orderDetail = orderDetailService.makeOrderDetail(orderDetailSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }
        Assertions.assertEquals(1L, orderDetail.getOrderId());
    }

    @Test
    void testOrderValidation_fail() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            orderDetailService.makeOrderDetail(orderDetailFail);
        });

        Assertions.assertEquals("orderDetail validation fail", e.getMessage());
    }
}
