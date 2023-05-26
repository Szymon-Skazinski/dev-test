package skazinski.szymon.task3;

import skazinski.szymon.utils.LineReader;

import java.io.InputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task3 {

    public int getNumberOfGraphs(InputStream inputStream) {
        LineReader lineReader = new LineReader(inputStream);
        int linesCount = lineReader.readNextInt();
        List<Graph> graphs = getGraphsFromInput(lineReader, linesCount);

        graphs.sort(Comparator.comparingInt(Graph::getFirst));

        List<Graph> joinedGraphs = joinGraphs(graphs);

        return joinedGraphs.size();
    }

    private List<Graph> getGraphsFromInput(LineReader lineReader, int linesCount) {
        List<Graph> graphs = new LinkedList<>();
        for (int i = 0; i < linesCount; i++) {
            Graph graph = new Graph();
            graph.addVertex(lineReader.readNextInt());
            graph.addVertex(lineReader.readNextInt());
            graphs.add(graph);
        }
        return graphs;
    }

    private List<Graph> joinGraphs(List<Graph> graphs) {
        List<Graph> joinedGraphs = new LinkedList<>();
        for (int i = 0; i < graphs.size(); i++) {
            Graph graph = graphs.get(i);
            for (Graph graph1 : graphs) {
                Integer firstVertex = graph.getFirst();
                Integer lastVertex = graph.getLast();

                Integer firstVertex1 = graph1.getFirst();
                Integer lastVertex1 = graph1.getLast();
                if (firstVertex.equals(lastVertex1) || lastVertex.equals(firstVertex1)) {
                    graph.joinGraphs(graph1);
                    i++;
                }
            }
            joinedGraphs.add(graph);
        }
        return joinedGraphs;
    }
}
