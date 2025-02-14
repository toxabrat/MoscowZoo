package org.example;

import java.util.Scanner;

public final class Input {

    private Input() {}

    private static Scanner input = new Scanner(System.in);

    public static String getString() {
        if (input.hasNextLine()) {
            return input.nextLine();
        } else {
            return null;
        }
    }

    public static void setScanner(Scanner newScanner) {
        input = newScanner;
    }
}