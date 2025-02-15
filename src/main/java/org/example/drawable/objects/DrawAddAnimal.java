package org.example.drawable.objects;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawAddAnimal {

    private DrawAddAnimal() {}

    private static final String EMPTY_STRING = "                                                                 ";
    public static final int STANDARD_MESSAGE_LENGTH = 65;
    private static final List<String> animalChoiceMenu = new ArrayList<>(Arrays.asList(
            "          в зоопарке уже знают о некотораых животных             ",
            "             вы можете просто ввести его название                ",
            "                 обезьяна, кролик, тигр, волк                    ",
            "         в следующей строке введите его здоровье(0 - 10)         ",
            "если вы хотите добавить свое животное то введите следующую информацию",
            "           каждое слово вводите с новой строки                   ",
            "     имя, здоровье(0 - 10), количество килограм его пищи         ",
            "введите хищник или травоядное если травоядное то введите доброту(0 - 10)",
            EMPTY_STRING
    ));

    private static final List<String> animalBeenAdd = new ArrayList<>(Arrays.asList(
            "                 Животное успешно добавленно                     "
    ));

    private static final List<String> animalNotBeenAdd = new ArrayList<>(Arrays.asList(
            "                введена некорректная информация                  "
    ));

        private static final List<String> animalHurt = new ArrayList<>(Arrays.asList(
            "                       животное больно                           "
    ));

    public static void drawAddAnimal(PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(animalChoiceMenu, output);
    }

    public static void drawBeenAdd(String name, PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(animalBeenAdd, output);
        int n = Math.max(STANDARD_MESSAGE_LENGTH - name.length(), 0) / 2;
        output.println(" ".repeat(n) + name);
    }

    public static void drawNotBeenAdd(PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(animalNotBeenAdd, output);
    }

    public static void drawHurt(PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(animalHurt, output);
    }
}
