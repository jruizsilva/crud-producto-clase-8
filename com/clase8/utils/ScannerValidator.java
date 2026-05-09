package com.clase8.utils;

import com.clase8.exceptions.InputNotValidException;

import java.util.Scanner;

public abstract class ScannerValidator {
    static Scanner sc = new Scanner(System.in);
    static String ERROR_MESSAGE = "Entrada ingresada no valida. Intente de nuevo.";

    public static String readString(String inputMessage) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine();
                if (input == null || input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                return input;
            } catch (InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readInteger(String inputMessage) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine();
                if (input == null || input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException | InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
