package com.example.pickingtdd.service;


import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.OrderStateEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    Order orderSuccess;
    Order orderFail;

    @BeforeEach
    public void orderInit() {
        orderSuccess = new Order();
        orderSuccess.setOrderId(1L);
        orderSuccess.setState(OrderStateEnum.ORDERED);

        orderFail = new Order();
        orderFail.setOrderId(null);
        orderFail.setState(null);
    }

    @Test
    public void testOrderMake_success() {
        Order order = new Order();

        try {
            order = orderService.makeOrder(orderSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }

        Assertions.assertEquals(1L, order.getOrderId());
        Assertions.assertEquals(OrderStateEnum.ORDERED, order.getState());
    }

    @Test
    void testOrderValidation_success() {
        Order order = new Order();

        try {
            order = orderService.makeOrder(orderSuccess);
        } catch (Exception e) {
            fail("should not throw exception");
        }

        Assertions.assertEquals(1L, order.getOrderId());
    }

    @Test
    void testOrderValidation_fail() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            orderService.makeOrder(orderFail);
        });

        Assertions.assertEquals("order validation fail", e.getMessage());
    }
}
