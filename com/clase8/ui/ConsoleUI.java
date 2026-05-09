package com.clase8.ui;

import com.clase8.models.Product;
import com.clase8.utils.ScannerValidator;

import java.util.*;

public class ConsoleUI {
    private static ConsoleUI instancia;
    List<Integer> validMenuOptions = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6)
    );

    private ConsoleUI() {
    }

    public static ConsoleUI getInstancia() {
        if (instancia == null) {
            instancia = new ConsoleUI();
        }
        return instancia;
    }

    public void showMenuOptions()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu\n");
        sb.append("1. Agregar producto\n");
        sb.append("2. Listar productos\n");
        sb.append("3. Actualizar producto\n");
        sb.append("4. Eliminar producto\n");
        sb.append("5. Crear un pedido\n");
        sb.append("6. Listar pedidos\n");
        sb.append("7. Salir\n");
        System.out.println(sb.toString());
    }

    public void showMenuOptionsInline(){
        System.out.println("1.Agregar 2.Listar 3.Actualizar 4.Eliminar 5.CrearPedido 6.ListarPedidos 7.Salir");
    }

    public int getOption() {
        return ScannerValidator.readInteger("Elija una opción(1-7): ", 1, 7);
    }

    public void showProducts(List<Product> products)
    {
        System.out.println("Listado de productos:");
        for(Product product : products){
            System.out.println(product);
        }
    }
}
