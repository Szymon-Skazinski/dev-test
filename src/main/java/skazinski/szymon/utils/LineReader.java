package skazinski.szymon.utils;

import java.io.InputStream;
import java.util.Scanner;

public class LineReader {

    private final Scanner scanner;

    public LineReader(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String[] readLine() {
        String line = scanner.nextLine();
        return line.split(" ");
    }

    public int readNextInt() {
        return scanner.nextInt();
    }
}
