package com.clase8.repository;

import com.clase8.exceptions.NotFoundException;
import com.clase8.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    List<Producto> productos;

    public ProductoRepository() {
        this.productos = new ArrayList<>();
    }

    public ProductoRepository(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public Producto getProductoById(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        throw new NotFoundException("No se encontró el producto con el id: " + id);
    }

    public void updateProducto(int productoId,
                               Producto producto) {
        for (Producto p : productos) {
            if (p.getId() == productoId) {
                p.setName(producto.getName());
                p.setPrice(producto.getPrice());
                p.setStock(producto.getStock());
            }
        }
    }
}
