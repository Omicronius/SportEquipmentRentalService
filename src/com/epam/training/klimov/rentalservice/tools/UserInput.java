package com.epam.training.klimov.rentalservice.tools;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Class contains main methods to handle user's input.
 *
 * @author Konstantin Klimov
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static String inputString() {
        String str;
        while (true) {
            str = scanner.nextLine();
            if (str.length() > 0) {
                return str;
            } else {
                System.out.println(Messages.ZERO_LENGTH_INPUT_STRING);
            }
        }
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
