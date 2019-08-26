package com.zc.springaoplearning.service;

import com.zc.springaoplearning.model.Order;


public interface OrderService {

    Order createOrder(String username, String product);

    Order queryOrder(String username);
}
