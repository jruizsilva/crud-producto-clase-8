package com.clase8.utils;

import com.clase8.models.Order;
import com.clase8.models.OrderItem;
import com.clase8.models.Product;
import com.clase8.repository.OrderRepository;
import com.clase8.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

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

    public static void fillOrderList(
            OrderRepository orderRepository,
            ProductRepository productRepository
    ) {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            System.out.println("No se pueden crear ordenes sin productos en la base de datos");
            return;
        }
        List<OrderItem> orderItems1 = new ArrayList<OrderItem>();

        for (int i=1; i<products.size(); i+=2) {
            OrderItem orderItem = new OrderItem(products.get(i), i);
            orderItems1.add(orderItem);
        }
        Order order1 = new Order(orderItems1);
        orderRepository.save(order1);

        List<OrderItem> orderItems2 = new ArrayList<OrderItem>();

        for (int i=1; i<products.size()/2; i++) {
            OrderItem orderItem = new OrderItem(products.get(i), i);
            orderItems2.add(orderItem);
        }
        Order order2 = new Order(orderItems2);
        orderRepository.save(order2);
    }
}
