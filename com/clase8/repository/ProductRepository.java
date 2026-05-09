package com.clase8.repository;

import com.clase8.exceptions.NotFoundException;
import com.clase8.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public List<Product> findAll() {
        return products;
    }

    public void save(Product product) {
        this.products.add(product);
    }

    public Product findById(int id) throws NotFoundException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new NotFoundException("No se encontró el producto con el id: " + id);
    }

    public void update(int productId, String productName, double productPrice, int stock) throws NotFoundException {
        Product product = this.findById(productId);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setStock(stock);
    }

    public void deleteById(int productId) {
        Product product = this.findById(productId);
        this.products.remove(product);
    }
}
