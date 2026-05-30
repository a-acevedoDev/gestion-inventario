package com.java.stock;

public interface StockMechanism {
    int getStock(int productId);
    void decreaseStock(int productId, int quantity);
    boolean isAvailable(int productId, int requiredQuantity);
    void increaseStock(int productId, int quantity);
}
