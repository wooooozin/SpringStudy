package com.example.pickingtdd.service;

import com.example.pickingtdd.entity.Order;
import com.example.pickingtdd.entity.PickingList;

public interface PickingListService {
    PickingList makePickingList(Order order);

}
