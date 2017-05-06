package com.epam.training.klimov.rentalservice.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class UserInputHandler contains methods for interpretation user input.
 *
 * @author Konstantin Klimov
 */

public class UserInputHandler {
    private static Scanner input = new Scanner(System.in);

    public static int inputNumber(){
        int number;
        input = new Scanner(System.in);
        try {
            number = input.nextInt();
            return number;
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}