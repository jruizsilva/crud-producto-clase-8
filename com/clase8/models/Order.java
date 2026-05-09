package com.clase8.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final List<OrderItem> items;
    private static int count = 0;

    public Order(){
        this.id = count++;
        this.items = new ArrayList<OrderItem>();
    }

    public Order(List<OrderItem> items) {
        this.items = items;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

}
