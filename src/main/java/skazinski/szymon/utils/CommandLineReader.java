package skazinski.szymon.utils;

import java.util.Scanner;

public class CommandLineReader implements Reader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String[] readLines() {
        String line = scanner.nextLine();
        return line.split(" ");
    }

    @Override
    public int readNextInt() {
        return scanner.nextInt();
    }
}
