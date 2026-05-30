package com.java.models;

public class ItemOrder {
    private int idProduct;
    private int quantity;

    public ItemOrder() {
    }

    public ItemOrder(int idProduct, int quantity) {
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
