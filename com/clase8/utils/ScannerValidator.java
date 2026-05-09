package com.clase8.utils;

import com.clase8.exceptions.InputNotValidException;
import com.clase8.exceptions.NumberOutOfRangeException;
import com.clase8.ui.ConsoleUI;

import java.util.Scanner;

public abstract class ScannerValidator {
    static Scanner sc = new Scanner(System.in);
    static String ERROR_MESSAGE = "Entrada ingresada no valida. Intente de nuevo.";

    public static String readString(String inputMessage) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine()
                                 .trim();
                if (input.isEmpty()) {
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
                String input = sc.nextLine()
                                 .trim();
                if (input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException | InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readInteger(String inputMessage,
                                  int minValue,
                                  int maxValue) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine()
                                 .trim();
                if (input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                int inputInteger = Integer.parseInt(input);
                if (inputInteger < minValue || inputInteger > maxValue) {
                    throw new NumberOutOfRangeException("Numero ingresado fuera de rango. Intente de nuevo.");
                }
                return inputInteger;
            } catch (NumberOutOfRangeException | NumberFormatException | InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double readDouble(String inputMessage) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException | InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double readDouble(String inputMessage,
                                    double minValue) {
        while (true) {
            try {
                System.out.println(inputMessage);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputNotValidException(ERROR_MESSAGE);
                }
                double inputDouble = Double.parseDouble(input);
                if (inputDouble <= minValue) {
                    throw new NumberOutOfRangeException("Numero ingresado fuera de rango. Intente de nuevo.");
                }
                return inputDouble;
            } catch (NumberOutOfRangeException | NumberFormatException | InputNotValidException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
