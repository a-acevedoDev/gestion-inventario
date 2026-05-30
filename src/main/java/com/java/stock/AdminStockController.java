package com.java.stock;

public class AdminStockController extends StockController {

    public AdminStockController(StockMechanism mechanism) {
        super(mechanism);
    }

    @Override
    public void showStockInfo(int productId) {
        int stock = mechanism.getStock(productId);
        System.out.println("=== ADMINISTRADOR ===");
        System.out.println("Producto ID: " + productId);
        System.out.println("Stock actual: " + stock);
        if (stock < 5) {
            System.out.println("⚠️ ALERTA: Stock bajo (menor a 5 unidades)");
        }
    }

    public void restockProduct(int productId, int quantity) {
        if (quantity > 0) {
            mechanism.increaseStock(productId, quantity);
            System.out.println("Reposición completada. Nuevo stock: " + mechanism.getStock(productId));
        }
    }

    public void setExactStock(int productId, int newQuantity) {
        if (newQuantity >= 0) {
            int current = mechanism.getStock(productId);
            if (newQuantity > current) {
                mechanism.increaseStock(productId, newQuantity - current);
            } else if (newQuantity < current) {
                mechanism.decreaseStock(productId, current - newQuantity);
            }
            System.out.println("Stock ajustado a: " + mechanism.getStock(productId));
        }
    }
}
