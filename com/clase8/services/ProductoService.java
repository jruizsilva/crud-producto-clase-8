package com.clase8.services;

import com.clase8.models.Producto;
import com.clase8.repository.ProductoRepository;

public class ProductoService {
    ProductoRepository repository;

    public ProductoService(ProductoRepository productoRepository) {
        this.repository = productoRepository;
    }

    public void addProducto(String nombre,
                            double price,
                            int stock) {
        Producto producto = new Producto(nombre, price, stock);
        repository.addProducto(producto);
    }
}
