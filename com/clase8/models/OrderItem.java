package com.clase8.models;

public class OrderItem {
    private final int id;
    private Product product;
    private int quantity;
    private static int count = 0;
    public OrderItem(){
        this.id = ++count;
    }
    public OrderItem(Product product, int quantity) {
        this.id = ++count;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "{ID=" + this.getId() + " | product=" + product.getName() + " | quantity=" + quantity + "}";
    }
}
