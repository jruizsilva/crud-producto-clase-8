package com.clase8.ui;

import com.clase8.exceptions.InvalidOptionException;
import com.clase8.models.Producto;
import com.clase8.utils.ScannerValidator;

import java.util.*;

public  class ConsoleUI {
    List<Integer> validOptions = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6)
    );
    public ConsoleUI() {}

    public void showMenu()
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

    public int getOption() {
        int opcion;
        while (true){
            try{
                opcion = ScannerValidator.readInteger("Elija una opción(1-7): ");
                if(!validOptions.contains(opcion)){
                    throw new InvalidOptionException("Opción ingresada no valida. Intente de nuevo.");
                }
                return opcion;
            }catch(InvalidOptionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void showProducts(List<Producto> productos)
    {
        if(productos == null || productos.isEmpty()){
            System.out.println("No existen productos en la base de datos");
            return;
        }
        for(Producto producto: productos){
            System.out.println(producto);
        }
    }
}
