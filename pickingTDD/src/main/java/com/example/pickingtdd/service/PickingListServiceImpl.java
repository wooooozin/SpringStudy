package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.OrderDetail;
import com.example.pickingtdd.entity.PickingList;
import com.example.pickingtdd.entity.Sku;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PickingListServiceImpl implements PickingListService {
    @Override
    public PickingList makePickingList(Order order) {
        PickingList pickingList = new PickingList();
        pickingList.setOrderId(order.getOrderId());
        pickingList.setState("NOTASSIGNED");

        Map<Sku, Integer> skuAountMap = new HashMap<>();
        for (OrderDetail orderDetail : order.getOrderDetailList()) {
            skuAountMap.put(orderDetail.getSku(), orderDetail.getAmount());
        }
        pickingList.setSkuAmountMap(skuAountMap);
        return pickingList;

    }
}
