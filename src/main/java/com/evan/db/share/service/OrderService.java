package com.evan.db.share.service;

import com.evan.db.share.domain.Order;

public interface OrderService {

    public void save(Order order);
    
    public Order getByOrder(String productCode,String orderNo);
}
