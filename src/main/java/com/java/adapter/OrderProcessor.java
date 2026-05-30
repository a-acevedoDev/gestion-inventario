package com.java.adapter;

import com.java.models.Order;

public interface OrderProcessor {
    boolean processOrder(Order order);
    double calculateTotal(Order order);
    boolean checkAvailability(Order order);
}
