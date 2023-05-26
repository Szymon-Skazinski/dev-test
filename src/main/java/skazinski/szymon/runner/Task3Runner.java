package skazinski.szymon.runner;

import skazinski.szymon.task.task3.Task3;
import skazinski.szymon.util.printer.Printer;
import skazinski.szymon.util.reader.Reader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task3Runner implements TaskRunner {

    private final Reader reader;
    private final Printer printer;

    public Task3Runner(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    @Override
    public void runTask() {
        String intro = "Please provide a positive number 'n' of lines in the first line, " +
                "and then 'n' lines contains pairs of positive integers, " +
                "where each pair identifies a connection between two vertices in graph ";
        printer.printLine(intro);

        int linesCount = reader.readNextInt();
        List<List<Integer>> graphsFromInput = getGraphsFromInput(linesCount);

        Task3 task3 = new Task3();
        int numberOfGraphs = task3.getNumberOfGraphs(graphsFromInput);
        printer.printLine("\nOutput:\n\n" + numberOfGraphs);
    }

    private List<List<Integer>> getGraphsFromInput( int linesCount) {
        List<List<Integer>> graphs = new LinkedList<>();
        for (int i = 0; i < linesCount; i++) {
            List<Integer> graph = new ArrayList<>();
            graph.add(reader.readNextInt());
            graph.add(reader.readNextInt());
            graphs.add(graph);
        }
        return graphs;
    }

}
