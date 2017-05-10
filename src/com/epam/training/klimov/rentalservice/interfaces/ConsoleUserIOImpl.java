package com.epam.training.klimov.rentalservice.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Администратор on 10.05.2017.
 */
public class ConsoleUserIOImpl implements IUserInputOutput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    @Override
    public String inputString() {
        return scanner.nextLine();
    }

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}
