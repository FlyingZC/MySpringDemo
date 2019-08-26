package com.zc.springaoplearning.service.imple;

import com.zc.springaoplearning.model.Order;
import com.zc.springaoplearning.service.OrderService;

public class OrderServiceImpl implements OrderService {


    @Override
    public Order createOrder(String username, String product) {
        Order order = new Order();
        order.setUsername(username);
        order.setProduct(product);
        return order;
    }

    @Override
    public Order queryOrder(String username) {
        Order order = new Order();
        order.setUsername("test");
        order.setProduct("test");
        return order;
    }
}
