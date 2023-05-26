package skazinski.szymon.task3;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
