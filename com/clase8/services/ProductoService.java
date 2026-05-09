package com.clase8.services;

import com.clase8.models.Product;
import com.clase8.repository.ProductRepository;
import com.clase8.ui.ConsoleUI;
import com.clase8.utils.ScannerValidator;

import java.util.List;

public class ProductoService {
    ProductRepository repository;
    ConsoleUI console;

    public ProductoService(ProductRepository productRepository) {
        this.repository = productRepository;
        this.console = ConsoleUI.getInstancia();
    }

    public void listProducts() {
        List<Product> products = repository.getProductos();
        if(products == null || products.isEmpty()){
            System.out.println("No existen productos en la base de datos");
            return;
        }
        console.showProducts(products);
    }

    public void createProduct() {
        String productName = ScannerValidator.readString("Ingrese el nombre del producto: ");
        double price = ScannerValidator.readDouble("Ingrese el precio del producto: ", 0);
        int stock = ScannerValidator.readInteger("Ingrese el stock del producto: ");

        Product product = new Product(productName, price, stock);
        repository.addProduct(product);
    }
}
