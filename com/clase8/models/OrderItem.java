package com.clase8.models;

public class OrderItem {
    private final int id;
    private Product product;
    private int quantity;
    private int count = 0;
    public OrderItem(){
        this.id = ++count;
    }
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.id = ++count;
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
}
