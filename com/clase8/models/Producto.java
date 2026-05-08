package com.clase8.models;

public class Producto {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Producto() {
    }
    public Producto(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return "Producto{" + "name=" + name + ", price=" + price + ", stock=" + stock + '}';
    }
}
