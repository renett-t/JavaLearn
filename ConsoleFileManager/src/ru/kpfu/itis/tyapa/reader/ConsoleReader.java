package ru.kpfu.itis.tyapa.reader;

import ru.kpfu.itis.tyapa.exceptions.ReaderException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleReader implements ReaderInterface {
    private Scanner scanner;


    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readOneLine() {
        String result;

        try {
            result = scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException ex1) {
            throw new ReaderException(" Problems with reading your command");
        }

        return result;
    }

}
