package skazinski.szymon.task3;

import skazinski.szymon.utils.LineReader;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public void getNumberOfGraphs(InputStream inputStream) {
        LineReader lineReader = new LineReader(inputStream);

        int linesCount = lineReader.readNextInt();

        List<Graph> graphs = getGraphsFromInput(lineReader, linesCount);

        graphs.sort(Comparator.comparingInt(Graph::getFirst));

        List<Graph> joinedGraphs = joinGraphs(graphs);

        System.out.println(joinedGraphs.size());
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
}

class Graph implements Comparable<Graph> {

    SortedSet<Integer> vertices = new TreeSet<>();

    public void addVertex(Integer value) {
        vertices.add(value);
    }

    public void joinGraphs(Graph graph) {
        vertices.addAll(graph.vertices);
    }

    public Integer getLast() {
        return vertices.last();
    }

    public Integer getFirst() {
        return vertices.first();
    }

    @Override
    public String toString() {
        return vertices.stream().map(Object::toString).collect(Collectors.joining("-", "[", "]"));
    }

    @Override
    public int compareTo(Graph o) {
        return this.getFirst() - o.getFirst();
    }
}
