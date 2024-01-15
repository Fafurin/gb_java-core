package ru.fafurin.javacore.second.repository;

import ru.fafurin.javacore.second.entity.Product;

import java.util.ArrayList;
import java.util.Collections;

public class ProductRepository {

    private ArrayList<Product> products = new ArrayList<>();

    public void setProducts(Product[] products) {
        Collections.addAll(this.products, products);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
