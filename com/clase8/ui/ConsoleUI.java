package com.clase8.ui;

import com.clase8.exceptions.InvalidOptionException;

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
        sb.append("1. Listar productos\n");
        sb.append("2. Buscar producto por id\n");
        sb.append("3. Agregar producto\n");
        sb.append("4. Modificar producto\n");
        sb.append("5. Eliminar producto\n");
        sb.append("6. Salir\n");
        System.out.println(sb.toString());
    }

    public int getOption() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true){
            try{
                System.out.println("Introduce el opción: ");
                opcion = sc.nextInt();
                if(!validOptions.contains(opcion)){
                    throw new InvalidOptionException("Opción ingresada no valida. Intente de nuevo.");
                }
                return  opcion;
            }catch(InputMismatchException e){
                System.out.println("Opción ingresada no valida. Intente de nuevo.");
                sc.nextLine();
            }catch(InvalidOptionException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
