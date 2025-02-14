package org.example;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InputTest {
    @Test
    void shouldGetFirstLine() {
        Input.setScanner(new Scanner(new ByteArrayInputStream("aaa".getBytes())));

        assertEquals("aaa", Input.getString());
    }

    @Test
    void shouldGetSecondLine() {
        Input.setScanner(new Scanner(new ByteArrayInputStream("aaa\nkkk".getBytes())));

        Input.getString();

        assertEquals("kkk", Input.getString());
    }

    @Test
    void shouldGetNull() {
        Input.setScanner(new Scanner(new ByteArrayInputStream("".getBytes())));

        assertNull(Input.getString());
    }
}