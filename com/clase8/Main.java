package com.clase8;

import com.clase8.repository.ProductoRepository;
import com.clase8.services.ProductoService;
import com.clase8.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);

        console.showMenu();
        int opcion;
        do {
            opcion = console.getOption();

            switch (opcion) {
                case 1: productoService.addProducto();
                case 2: console.showProducts(productoService.getProductos());
            }
        } while (opcion != 5);
    }
}
