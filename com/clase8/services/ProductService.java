package com.clase8.services;

import com.clase8.exceptions.NotFoundException;
import com.clase8.models.Product;
import com.clase8.repository.ProductRepository;
import com.clase8.ui.ConsoleUI;
import com.clase8.utils.ScannerValidator;

import java.util.List;

public class ProductService {
    ProductRepository repository;
    ConsoleUI console;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
        this.console = ConsoleUI.getInstancia();
    }

    public void listProducts() {
        List<Product> products = repository.findAll();
        if(products == null || products.isEmpty()){
            System.out.println("No existen productos en la base de datos");
            return;
        }
        console.showProducts(products);
    }

    public void createProduct() {
        String productName = ScannerValidator.readString("Ingrese el nombre del producto: ");
        double price = ScannerValidator.readDouble("Ingrese el precio del producto: ", 0);
        int stock = ScannerValidator.readInteger("Ingrese el stock del producto: ");

        Product product = new Product(productName, price, stock);
        repository.save(product);
        System.out.println("Producto agregado "+product);
    }

    public void updateProduct() {
        int productId;
        boolean updated = false;
        do{
            productId = ScannerValidator.readInteger("Ingrese el id del producto a editar: ");
            try{
                Product product = repository.findById(productId);
                System.out.println("Editando el producto: "+product);
                String newProductName = ScannerValidator.readString("Ingrese el nuevo nombre del producto: ");
                double newProductPrice = ScannerValidator.readDouble("Ingrese el nuevo precio del producto: ");
                int newStock = ScannerValidator.readInteger("Ingrese el nuevo stock del producto: ");
                repository.update(productId, newProductName, newProductPrice, newStock);
                System.out.println("Producto con id "+ productId +" actualizado.");
                updated = true;
            }catch (NotFoundException e){
                System.out.println(e.getMessage());
            }
        }while(!updated);
    }

    public void deleteProduct() {
        int productId;
        boolean deleted = false;
        do{
            productId = ScannerValidator.readInteger("Ingrese el id del producto a eliminar: ");
            try{
                repository.deleteById(productId);
                System.out.println("Producto con id "+ productId +" eliminado.");
                deleted = true;
            }catch (NotFoundException e){
                System.out.println(e.getMessage());
            }
        }while (!deleted);
    }
}
