package com.java.manager;

import com.java.models.Product;
import com.java.stock.StockMechanism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    private static ProductManager instance;
    private Map<Integer, Product> catalog;
    private Product basePrototype;
    private int nextId;

    private ProductManager() {
        catalog = new HashMap<>();
        nextId = 1;
        basePrototype = new Product(0, "", 0.0);
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public Product createNewProduct() {
        Product cloned = (Product) basePrototype.clone();
        cloned.setId(0);
        return cloned;
    }

    public void addProduct(Product product) {
        if (product == null) return;
        if (product.getId() <= 0) {
            product.setId(nextId);
            nextId++;
        }
        catalog.put(product.getId(), product);
    }

    public Product getProductById(int id) {
        return catalog.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(catalog.values());
    }

    public boolean productExists(int id) {
        return catalog.containsKey(id);
    }

    public void displayAllProducts(StockMechanism stockMechanism) {
        if (catalog.isEmpty()) {
            System.out.println("Inventario vacío");
            return;
        }
        for (Product p : catalog.values()) {
            int stockActual = stockMechanism.getStock(p.getId());
            System.out.println("ID:" + p.getId() + " | " + p.getName() +
                    " | $" + p.getPrice() + " | Stock:" + stockActual);
        }
    }
}
