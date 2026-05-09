package com.clase8.repository;

import com.clase8.exceptions.NotFoundException;
import com.clase8.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public void save(Order order) {
        orders.add(order);
    }

    public Order findById(Integer id) throws NotFoundException {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        throw new NotFoundException("Order with id " + id + " not found");
    }

    public List<Order> findAll() {
        return orders;
    }
    public void deleteById(Integer id) {
        Order order = findById(id);
        orders.remove(order);
    }

}
