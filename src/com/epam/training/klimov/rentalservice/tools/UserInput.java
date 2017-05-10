package com.epam.training.klimov.rentalservice.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Администратор on 10.05.2017.
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
        return scanner.nextLine();
    }

}
