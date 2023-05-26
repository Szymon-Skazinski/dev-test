package skazinski.szymon.task3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task3 {

    public int getNumberOfGraphs(List<List<Integer>> inputGraphs) {
        List<Graph> graphs = getGraphsFromInput(inputGraphs);

        graphs.sort(Comparator.comparingInt(Graph::getFirst));

        List<Graph> joinedGraphs = joinGraphs(graphs);

        return joinedGraphs.size();
    }

    private List<Graph> getGraphsFromInput(List<List<Integer>> inputGraphs) {
        List<Graph> graphs = new LinkedList<>();
        for (List<Integer> integers : inputGraphs) {
            Graph graph = new Graph();
            graph.addVertex(integers.get(0));
            graph.addVertex(integers.get(1));
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
