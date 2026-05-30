package com.java.stock;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStock implements StockMechanism {

    private Map<Integer, Integer> stockMap;

    public InMemoryStock() {
        stockMap = new HashMap<>();
    }

    @Override
    public int getStock(int productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    @Override
    public void decreaseStock(int productId, int quantity) {
        int current = getStock(productId);
        if (current >= quantity) {
            stockMap.put(productId, current - quantity);
        }
    }

    @Override
    public boolean isAvailable(int productId, int requiredQuantity) {
        return getStock(productId) >= requiredQuantity;
    }

    @Override
    public void increaseStock(int productId, int quantity) {
        int current = getStock(productId);
        stockMap.put(productId, current + quantity);
    }
}
