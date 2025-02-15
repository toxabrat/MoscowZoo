package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZooProcessingTest {
    @Test
    void shouldExitProcessing() {
        ZooProcessing zooProcessing = new ZooProcessing();
        ZooProcessing zooProcessing1 = new ZooProcessing();

        Input.setScanner(new Scanner(new ByteArrayInputStream("ВЫхоД".getBytes())));
        int totalCommand = zooProcessing.start(new PrintStream(new ByteArrayOutputStream()));
        Input.setScanner(new Scanner(new ByteArrayInputStream("".getBytes())));
        int totalCommand1 = zooProcessing1.start(new PrintStream(new ByteArrayOutputStream()));

        assertEquals(0, totalCommand);
        assertEquals(0, totalCommand1);
    }

    @Test
    void shouldWorkCorrectly() {
        ZooProcessing zooProcessing = new ZooProcessing();

        Input.setScanner(new Scanner(
                new ByteArrayInputStream("2\n3\n4\n1\nобезьяна\n2\n1\nвыхухоль\n10\n23\nтравоядное\n7".getBytes())));
        int totalCommand = zooProcessing.start(new PrintStream(new ByteArrayOutputStream()));

        assertEquals(5, totalCommand);
    }

    @Test
    void shouldPrintZoo() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ZooProcessing zooProcessing = new ZooProcessing();
        String ans;

        Input.setScanner(new Scanner(
                new ByteArrayInputStream("1\nобезьяна\n10\n2".getBytes())));
        zooProcessing.start(printStream);
        ans = byteArrayOutputStream.toString();

        assertTrue(ans.contains("1 обезьяна\n"));
    }

    @Test
    void shouldPrintKg() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ZooProcessing zooProcessing = new ZooProcessing();
        String ans;

        Input.setScanner(new Scanner(
                new ByteArrayInputStream("1\nобезьяна\n10\n3".getBytes())));
        zooProcessing.start(printStream);
        ans = byteArrayOutputStream.toString();

        assertTrue(ans.contains("3\n"));
    }

    @Test
    void shouldPrintContactAnimal() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ZooProcessing zooProcessing = new ZooProcessing();
        String ans;

        Input.setScanner(new Scanner(
                new ByteArrayInputStream("1\nобезьяна\n10\n4".getBytes())));
        zooProcessing.start(printStream);
        ans = byteArrayOutputStream.toString();

        assertTrue(ans.contains("1 обезьяна\n"));
    }
}
