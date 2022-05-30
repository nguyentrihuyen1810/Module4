package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Samsung", 15000000, "phone", "Korea"));
        products.put(2, new Product(2, "Nokia", 7000000, "phone", "VietNam"));
        products.put(3, new Product(3, "Iphone", 32000000, "phone", "USA"));
        products.put(4, new Product(4, "Oppo", 7500000, "phone", "China"));
        products.put(5, new Product(5, "Xiaomi", 5000000, "phone", "China"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
