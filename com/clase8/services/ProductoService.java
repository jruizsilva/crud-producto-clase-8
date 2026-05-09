package com.clase8.services;

import com.clase8.models.Producto;
import com.clase8.repository.ProductoRepository;
import com.clase8.utils.ScannerValidator;

import java.util.List;

public class ProductoService {
    ProductoRepository repository;

    public ProductoService(ProductoRepository productoRepository) {
        this.repository = productoRepository;
    }

    public List<Producto> getProductos() {
        return repository.getProductos();
    }

    public void addProducto() {
        Producto producto = new Producto();
        String productName = ScannerValidator.readString("Ingrese el nombre del producto: ");
        repository.addProducto(producto);
    }
}
