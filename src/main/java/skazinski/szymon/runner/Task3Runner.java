package skazinski.szymon.runner;

import skazinski.szymon.task3.Task3;
import skazinski.szymon.utils.CommandLineReader;
import skazinski.szymon.utils.Printer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task3Runner implements TaskRunner {

    private final CommandLineReader reader;
    private final Printer printer;

    public Task3Runner(InputStream inputStream, Printer printer) {
        this.reader = new CommandLineReader(inputStream);
        this.printer = printer;
    }

    @Override
    public void runTask() {
        String intro = "Please provide a positive number 'n' of lines in the first line, " +
                "and then 'n' lines contains pairs of positive integers, " +
                "where each pair identifies a connection between two vertices in graph ";
        printer.printLine(intro);

        int linesCount = reader.readNextInt();
        List<List<Integer>> graphsFromInput = getGraphsFromInput(reader, linesCount);

        Task3 task3 = new Task3();
        int numberOfGraphs = task3.getNumberOfGraphs(graphsFromInput);
        printer.printLine("\nOutput:\n" + numberOfGraphs);
    }

    private static List<List<Integer>> getGraphsFromInput(CommandLineReader commandLineReader, int linesCount) {
        List<List<Integer>> graphs = new LinkedList<>();
        for (int i = 0; i < linesCount; i++) {
            List<Integer> graph = new ArrayList<>();
            graph.add(commandLineReader.readNextInt());
            graph.add(commandLineReader.readNextInt());
            graphs.add(graph);
        }
        return graphs;
    }

}
