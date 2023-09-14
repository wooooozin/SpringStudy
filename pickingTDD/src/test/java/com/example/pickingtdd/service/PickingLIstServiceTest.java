package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.*;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;


@SpringBootTest
public class PickingLIstServiceTest {

    @Autowired
    PickingListService pickingListService;

    Order order;
    @BeforeEach
    void orderSetup() {
        order = new Order();
        order.setOrderId(1L);
        order.setState(OrderStateEnum.ORDERED);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1L);
        orderDetail.setAmount(10);
        orderDetail.setOrderDetailId(1L);
        orderDetail.setSku(new Sku());

        order.setOrderDetailList(Arrays.asList(orderDetail));
    }


    @Test
    void testMakePickingList() {
        //given
        PickingList assertPickingList = new PickingList();
        assertPickingList.setOrderId(1L);
        assertPickingList.setSkuAmountMap(
                Maps.newHashMap(
                        order.getOrderDetailList().get(0).getSku(),
                        order.getOrderDetailList().get(0).getAmount()
                        )
        );
        assertPickingList.setState("NOTASSIGNED");
        assertPickingList.setPicker(null);

        PickingList pickingList = pickingListService.makePickingList(order);

        // then
        Assertions.assertEquals(assertPickingList.getOrderId(), pickingList.getOrderId());
        Assertions.assertEquals("NOTASSIGNED", pickingList.getState());
        Assertions.assertEquals(
                assertPickingList.getSkuAmountMap().get(
                        order.getOrderDetailList().get(0).getSku()),
                pickingList.getSkuAmountMap().get(
                        order.getOrderDetailList().get(0).getSku())
                );
    }
}

