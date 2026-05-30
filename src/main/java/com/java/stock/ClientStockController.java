package com.java.stock;

public class ClientStockController extends StockController {

    public ClientStockController(StockMechanism mechanism) {
        super(mechanism);
    }

    @Override
    public void showStockInfo(int productId) {
        int stock = mechanism.getStock(productId);
        System.out.println("=== CLIENTE ===");
        System.out.println("Producto ID: " + productId);
        if (stock > 0) {
            System.out.println("Disponible. Unidades: " + stock);
        } else {
            System.out.println("Producto agotado");
        }
    }

    public boolean canPurchase(int productId, int quantity) {
        return mechanism.isAvailable(productId, quantity);
    }
}