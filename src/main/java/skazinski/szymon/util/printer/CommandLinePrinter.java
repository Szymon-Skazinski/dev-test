package skazinski.szymon.util.printer;

public class CommandLinePrinter implements Printer {

    @Override
    public void printLine(String string) {
        System.out.println(string);
    }
}
