package org.example.drawable.objects;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DrawStart {
    private static final List<String> ZOO_PARK = new ArrayList<>(Arrays.asList(
            "  ZZZZZZZ   OOOOO   OOOOO      PPPPPP   AAAAA   RRRRRR   K   K  ",
            "      Z   O     O O     O     P     P A     A  R     R  K  K   ",
            "     Z    O     O O     O     PPPPPP  AAAAAAA  RRRRRR   KKK    ",
            "    Z     O     O O     O     P       A     A  R  R     K  K   ",
            "  ZZZZZZZ   OOOOO   OOOOO      P       A     A  R   R    K   K  "
    ));

    private static final String EMPTY_STRING = "                                                                 ";
    private static final List<String> mainChoiceMenu = new ArrayList<>(Arrays.asList(
            ZOO_PARK.getFirst(),
            ZOO_PARK.get(1),
            ZOO_PARK.get(2),
            ZOO_PARK.get(3),
            ZOO_PARK.get(4),
            EMPTY_STRING,
            EMPTY_STRING,
            "                 Добро пожаловать в зоопарк                     ",
            "      далее введите номер действия который вы хотите сделать     ",
            "      1)    вы можете привести в него новое животное             ",
            "      2)      узнать какие животные есть в зоопарке              ",
            "      3)   узнать сколько килограмм мяса нужно животным          ",
            "      4)   А также узнать всех контактных животных               ",
            "            для завершения работы введите выход                  ",
            "                         !!!УДАЧИ!!!                             ",
            EMPTY_STRING
    ));

    public static void mainMenu(PrintStream output) {
        DrawNewWindow.drawWindow(output);
        DrawPicture.drawList(mainChoiceMenu, output);
    }
}