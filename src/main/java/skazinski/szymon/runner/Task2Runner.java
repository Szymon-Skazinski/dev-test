package skazinski.szymon.runner;

import skazinski.szymon.task2.Task2;
import skazinski.szymon.util.printer.Printer;
import skazinski.szymon.util.reader.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task2Runner implements TaskRunner {

    private final Reader reader;
    private final Printer printer;

    public Task2Runner(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    @Override
    public void runTask() {
        printer.printLine("Please provide list of integers separated by space: ");

        String[] strings = reader.readLines();
        List<Integer> integers = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());

        Task2 task2 = new Task2();
        List<List<Integer>> pairs = task2.getPairs(integers);

        String output = pairs.stream()
                .map(ints -> ints.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));

        printer.printLine("\nOutput:\n\n" + output);

    }
}
