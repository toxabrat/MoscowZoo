package org.example.drawable.objects;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawKGNumber {

    private DrawKGNumber() {}

    public static final int STANDARD_MESSAGE_LENGTH = 65;

    public static void drawKGNumber(int kg, PrintStream output) {
        int n = Math.max(STANDARD_MESSAGE_LENGTH - Integer.toString(kg).length(), 0) / 2;
        DrawNewWindow.drawWindow(output);
        output.println(" ".repeat(n) + Integer.toString(kg));
    }
}
