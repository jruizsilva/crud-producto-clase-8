package com.clase8;

import com.clase8.exceptions.InvalidOptionException;
import com.clase8.ui.ConsoleUI;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();

        console.showMenu();
        int opcion;
        do {
            opcion = console.getOption();
            System.out.println("La opción seleccionada es: " + opcion);
        } while (opcion != 5);
    }
}
