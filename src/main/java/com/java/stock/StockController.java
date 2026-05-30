package com.java.stock;

public abstract class StockController {

    protected StockMechanism mechanism; // Puente

    public StockController(StockMechanism mechanism) {
        this.mechanism = mechanism;
    }

    public int checkStock(int productId) {
        return mechanism.getStock(productId);
    }

    public boolean verifyAvailability(int productId, int quantity) {
        return mechanism.isAvailable(productId, quantity);
    }

    public abstract void showStockInfo(int productId);
}
