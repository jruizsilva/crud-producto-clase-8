package com.clase8.services;

import com.clase8.exceptions.NotFoundException;
import com.clase8.models.Order;
import com.clase8.models.OrderItem;
import com.clase8.models.Product;
import com.clase8.repository.OrderRepository;
import com.clase8.repository.ProductRepository;
import com.clase8.ui.ConsoleUI;
import com.clase8.utils.ScannerValidator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderRepository orderRepository;
    ProductRepository productRepository;
    ConsoleUI console = ConsoleUI.getInstancia();

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void listOrders() {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            System.out.println("No se encontraron ordenes en la base de datos");
            return;
        }
        System.out.println("Lista de pedidos:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void createOrder() {
        List<Product> products = productRepository.findAll();
        boolean creatingOrder = true;
        List<OrderItem> orderItems = new ArrayList<>();
        do {
            try{
                System.out.println("Creando pedido...");
                System.out.println("1. Listar todos los productos");
                System.out.println("2. Agregar un producto al pedido");
                System.out.println("3. Finalizar la creación del pedido");

                int option = ScannerValidator.readInteger("Ingrese una opción(1-3)");

                switch (option) {
                    case 1: console.showProducts(products); break;
                    case 2:
                        int productId = ScannerValidator.readInteger("Introduce el id del producto: ");
                        Product product = productRepository.findById(productId);
                        System.out.println("Agregando al pedido el producto" + product);
                        int quantity = ScannerValidator.readInteger("Introduce la cantidad del producto: ");
                        orderItems.add(new OrderItem(product, quantity));
                        System.out.println("Producto agregado al pedido");
                        System.out.println(orderItems);
                        break;
                    case 3: creatingOrder = false; break;
                }
            }catch(NotFoundException e){
                System.out.println(e.getMessage());
            }

        } while (creatingOrder);

        if(!orderItems.isEmpty()) {
            Order order = new Order(orderItems);
            orderRepository.save(order);
            System.out.println("Pedido creado correctamente " + order);
        }else{
            System.out.println("No se agregaron productos al pedido y fue cancelado");
        }

    }
}
