package com.clase8;

import com.clase8.models.OrderItem;
import com.clase8.models.Product;
import com.clase8.repository.OrderRepository;
import com.clase8.repository.ProductRepository;
import com.clase8.services.OrderService;
import com.clase8.services.ProductService;
import com.clase8.ui.ConsoleUI;
import com.clase8.utils.DataLoader;

public class Main {
    public static void main(String[] args) {
        ConsoleUI console = ConsoleUI.getInstancia();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(orderRepository, productRepository);
        DataLoader.fillProductList(productRepository);
        DataLoader.fillOrderList(orderRepository, productRepository);

        console.showMenuOptions();
        int opcion;
        do {
            opcion = console.getOption();

            switch (opcion) {
                case 1: productService.createProduct(); break;
                case 2: productService.listProducts(); break;
                case 3: productService.updateProduct(); break;
                case 4: productService.deleteProduct(); break;
                case 5: orderService.createOrder(); break;
                case 6: orderService.listOrders(); break;
            }
            if (opcion != 7) {
                console.showMenuOptionsInline();
            }
        } while (opcion != 7);
    }
}
