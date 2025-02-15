package org.example.drawable.objects;

import java.io.PrintStream;

public final class DrawNewWindow {
    private DrawNewWindow() {}

    private static final int NUMBER_OF_LINES = 50;

    public static void drawWindow(PrintStream output) {
        output.println("\n".repeat(NUMBER_OF_LINES));
    }
}