package skazinski.szymon.runner;

import skazinski.szymon.task1.Measurements;
import skazinski.szymon.task1.Task1;
import skazinski.szymon.util.printer.Printer;
import skazinski.szymon.util.reader.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1Runner implements TaskRunner {

    private final Reader reader;
    private final Printer printer;

    public Task1Runner(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    @Override
    public void runTask() {
        printer.printLine("Please provide list of integers separated by space: ");
        String[] strings = reader.readLines();
        List<Integer> integers = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());

        Task1 task1 = new Task1();
        Measurements measurements = task1.getBasicMeasurements(integers);

        printer.printLine("\nOutput:\n\n" + measurements);

    }
}
