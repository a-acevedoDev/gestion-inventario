package com.java.models;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private List<ItemOrder> items;
    private Date orderDate;
    private OrderState orderState;

    public Order() {
    }

    public Order(int id, List<ItemOrder> items, Date orderDate, OrderState orderState) {
        this.id = id;
        this.items = items;
        this.orderDate = orderDate;
        this.orderState = orderState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemOrder> getItems() {
        return items;
    }

    public void setItems(List<ItemOrder> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
