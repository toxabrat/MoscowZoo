package org.example.drawable.objects;

import java.io.PrintStream;
import java.util.List;

public class DrawPicture {

    private DrawPicture() {}

    public static void drawList(List<String> picture, PrintStream output) {
        for (var i : picture) {
            output.println(i);
        }
    }
}
