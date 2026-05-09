package com.clase8;

import com.clase8.repository.OrderRepository;
import com.clase8.repository.ProductRepository;
import com.clase8.services.ProductoService;
import com.clase8.ui.ConsoleUI;
import com.clase8.utils.DataLoader;

public class Main {
    public static void main(String[] args) {
        ConsoleUI console = ConsoleUI.getInstancia();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductoService productoService = new ProductoService(productRepository);
        DataLoader.fillProductList(productRepository);
        DataLoader.fillOrderList(orderRepository, productRepository);

        console.showMenuOptions();
        int opcion;
        do {
            opcion = console.getOption();

            switch (opcion) {
                case 1: productoService.createProduct(); break;
                case 2: productoService.listProducts(); break;
                case 3: productoService.updateProduct(); break;
            }
            if (opcion != 5) {
                console.showMenuOptionsInline();
            }
        } while (opcion != 5);
    }
}
