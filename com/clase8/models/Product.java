package com.clase8.models;

public class Product {
    private final int id;
    private String name;
    private double price;
    private int stock;
    private static int count = 0;

    public Product() {
        this.id = ++count;
    }
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = ++count;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID=" + id + "| name=" + name + "| price=" + price + "| stock=" + stock;
    }
}
