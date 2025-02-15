package org.example.drawable.objects;

import java.io.PrintStream;
import java.util.List;

public class DrawAnimals {

    private DrawAnimals() {}

    public static void drawAnimals(List<String> animals, PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(animals, output);
    }
}
