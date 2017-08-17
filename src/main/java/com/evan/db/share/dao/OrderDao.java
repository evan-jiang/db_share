package com.evan.db.share.dao;

import com.evan.db.share.domain.Order;

public interface OrderDao {

    public int insert(Order order);
    
    public Order selectByOrder(Order order);
}
