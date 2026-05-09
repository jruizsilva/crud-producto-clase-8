package com.clase8.utils;

import com.clase8.models.Product;
import com.clase8.repository.ProductRepository;

public abstract class DataLoader {
    public static void fillProductList(ProductRepository productRepository) {

            productRepository.addProduct(new Product(
                    "Notebook Lenovo",
                    1250.99,
                    10
            ));

            productRepository.addProduct(new Product(
                    "Mouse Logitech",
                    25.50,
                    50
            ));

            productRepository.addProduct(new Product(
                    "Teclado Redragon",
                    75.99,
                    30
            ));

            productRepository.addProduct(new Product(
                    "Monitor Samsung 24",
                    320.00,
                    15
            ));

            productRepository.addProduct(new Product(
                    "Auriculares HyperX",
                    89.90,
                    20
            ));

            productRepository.addProduct(new Product(
                    "Disco SSD 1TB",
                    140.75,
                    18
            ));

            productRepository.addProduct(new Product(
                    "Webcam Logitech HD",
                    65.40,
                    12
            ));

            productRepository.addProduct(new Product(
                    "Silla Gamer",
                    450.00,
                    5
            ));
        }
}
