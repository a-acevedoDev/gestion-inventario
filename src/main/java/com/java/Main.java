package com.java;

import com.java.models.*;
import com.java.manager.ProductManager;
import com.java.stock.*;
import com.java.adapter.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Singleton
        System.out.println("Probando Singleton:");

        ProductManager pm1 = ProductManager.getInstance();
        ProductManager pm2 = ProductManager.getInstance();

        System.out.println("Misma instancia: " + (pm1 == pm2));


        // Prototype
        System.out.println("\nProbando Prototype:");

        Product laptop = pm1.createNewProduct();
        laptop.setName("Laptop Gamer");
        laptop.setPrice(520000.0);
        pm1.addProduct(laptop);

        Product mouse = pm1.createNewProduct();
        mouse.setName("Mouse Inalambrico");
        mouse.setPrice(45000.0);
        pm1.addProduct(mouse);

        System.out.println("  Productos creados por clon: " + laptop.getName() + ", " + mouse.getName());


        // Bridge
        System.out.println("\nProbando Bridge:");

        StockMechanism stockImpl = new InMemoryStock();

        stockImpl.increaseStock(laptop.getId(), 10);
        stockImpl.increaseStock(mouse.getId(), 50);

        StockController adminUI = new AdminStockController(stockImpl);
        StockController clientUI = new ClientStockController(stockImpl);

        System.out.println("Stock laptop (Admin): " + adminUI.checkStock(laptop.getId()));
        System.out.println("Stock laptop (Cliente): " + clientUI.checkStock(laptop.getId()));


        // Adapter
        System.out.println("\nProbando Adapter:");

        OrderProcessor processor = new OrderAdapter(pm1, stockImpl);

        Order pedido = new Order();
        pedido.setId(1);
        pedido.setOrderState(OrderState.PENDIENTE);

        List<ItemOrder> items = new ArrayList<>();
        items.add(new ItemOrder(laptop.getId(), 2));
        items.add(new ItemOrder(mouse.getId(), 3));
        pedido.setItems(items);

        double total = processor.calculateTotal(pedido);
        System.out.println("Total del pedido: $" + total);

        boolean procesado = processor.processOrder(pedido);
        System.out.println("Pedido procesado: " + procesado);
        System.out.println("Estado del pedido: " + pedido.getOrderState());

        System.out.println("Stock laptop después del pedido: " + stockImpl.getStock(laptop.getId()));
        System.out.println("Stock mouse después del pedido: " + stockImpl.getStock(mouse.getId()));
    }
}