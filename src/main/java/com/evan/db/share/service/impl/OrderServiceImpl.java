package com.evan.db.share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.evan.db.share.DynamicTransactionTemplate;
import com.evan.db.share.dao.OrderDao;
import com.evan.db.share.domain.Order;
import com.evan.db.share.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    
    @Autowired
    private DynamicTransactionTemplate dynamicTransactionTemplate;
    
    public void save(final Order order) {
        dynamicTransactionTemplate.resetTransactionTemplate(order.getProductCode()).execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus status) {
                orderDao.insert(order);
                return null;
            }
        });
    }

    public Order getByOrder(String productCode, String orderNo) {
        Order order = new Order();
        order.setProductCode(productCode);
        order.setOrderNo(orderNo);
        return orderDao.selectByOrder(order);
    }

}
