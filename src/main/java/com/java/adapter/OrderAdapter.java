package com.java.adapter;

import com.java.manager.ProductManager;
import com.java.models.ItemOrder;
import com.java.models.Order;
import com.java.models.Product;
import com.java.stock.StockMechanism;

public class OrderAdapter implements OrderProcessor{

    private ProductManager productManager;
    private StockMechanism stockMechanism;

    public OrderAdapter(ProductManager productManager, StockMechanism stockMechanism) {
        this.productManager = productManager;
        this.stockMechanism = stockMechanism;
    }

    @Override
    public boolean checkAvailability(Order order) {
        for (ItemOrder item : order.getItems()) {
            int productId = item.getIdProduct();
            int quantity = item.getQuantity();

            if (!productManager.productExists(productId)) {
                System.out.println("Producto ID " + productId + " no existe");
                return false;
            }

            if (!stockMechanism.isAvailable(productId, quantity)) {
                System.out.println("Stock insuficiente para producto ID " + productId);
                return false;
            }
        }
        return true;
    }

    @Override
    public double calculateTotal(Order order) {
        double total = 0.0;

        for (ItemOrder item : order.getItems()) {
            int productId = item.getIdProduct();
            int quantity = item.getQuantity();

            Product product = productManager.getProductById(productId);

            if (product != null) {
                total += product.getPrice() * quantity;
            }
        }

        return total;
    }

    @Override
    public boolean processOrder(Order order) {
        System.out.println("=== Procesando pedido ===");

        if (!checkAvailability(order)) {
            System.out.println("Pedido RECHAZADO: falta stock o producto no existe");
            return false;
        }

        double total = calculateTotal(order);
        System.out.println("Total del pedido: $" + total);

        for (ItemOrder item : order.getItems()) {
            int productId = item.getIdProduct();
            int quantity = item.getQuantity();

            stockMechanism.decreaseStock(productId, quantity);
            System.out.println("Descontado " + quantity + " unidades del producto ID " + productId);
        }

        order.setOrderState(com.java.models.OrderState.COMPLETA);

        System.out.println("Pedido ACEPTADO y procesado correctamente");
        return true;
    }
}
