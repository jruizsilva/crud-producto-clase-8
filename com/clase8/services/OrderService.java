package com.clase8.services;

import com.clase8.models.Order;
import com.clase8.repository.OrderRepository;

import java.util.List;

public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void listOrders(){
        List<Order> orders = orderRepository.findAll();
        if(orders.isEmpty()){
            System.out.println("No se encontraron ordenes en la base de datos");
            return;
        }
        for(Order order:orders){
            System.out.println("Lista de ordenes:");
            System.out.println(order);
        }
    }

    public void createOrder() {
        System.out.println("Creando una orden");
    }
}
