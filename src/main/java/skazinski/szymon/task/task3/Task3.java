package skazinski.szymon.task.task3;

import java.util.*;

public class Task3 {

    Set<Integer> visited = new HashSet<>();

    public int getNumberOfGraphs(List<List<Integer>> inputGraphs) {
        Map<Integer, Set<Integer>> adjacencyList = buildAdjacencyMap(inputGraphs);

        int separatedGraphsCount = 0;

        for (Integer vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                depthFirstSearch(vertex, adjacencyList);
                separatedGraphsCount++;
            }
        }

        return separatedGraphsCount;
    }

    private Map<Integer, Set<Integer>> buildAdjacencyMap(List<List<Integer>> inputGraphs) {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();

        for (List<Integer> connection : inputGraphs) {
            int vertex1 = connection.get(0);
            int vertex2 = connection.get(1);

            adjacencyMap.putIfAbsent(vertex1, new HashSet<>());
            adjacencyMap.putIfAbsent(vertex2, new HashSet<>());

            adjacencyMap.get(vertex1).add(vertex2);
            adjacencyMap.get(vertex2).add(vertex1);
        }

        return adjacencyMap;
    }

    private void depthFirstSearch(Integer vertex, Map<Integer, Set<Integer>> adjacencyMap) {
        visited.add(vertex);

        for (Integer adjacentVertex : adjacencyMap.get(vertex)) {
            if (!visited.contains(adjacentVertex)) {
                depthFirstSearch(adjacentVertex, adjacencyMap);
            }
        }
    }
}
