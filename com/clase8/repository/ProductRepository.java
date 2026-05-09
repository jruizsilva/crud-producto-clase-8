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

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProductos() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public Product getProductById(int id) throws NotFoundException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new NotFoundException("No se encontró el producto con el id: " + id);
    }

    public void updateProduct(int productId, String productName, double productPrice, int stock) throws NotFoundException {
        Product product = this.getProductById(productId);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setStock(stock);
    }
}
