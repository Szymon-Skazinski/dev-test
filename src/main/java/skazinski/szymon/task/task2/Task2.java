package skazinski.szymon.task.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public List<List<Integer>> getPairs(List<Integer> integers, int givenSum) {
        return findPairs(integers, givenSum)
                .stream()
                .sorted(Comparator.comparingInt(o -> o.get(0)))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> findPairs(List<Integer> numbers, int givenSum) {
        HashMap<Integer, Integer> integersByOccurrence = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();

        for (Integer number : numbers) {
            if (integersByOccurrence.containsKey(givenSum - number)) {
                for (int j = 1; j <= integersByOccurrence.get(givenSum - number); j++) {
                    List<Integer> pair = new ArrayList<>(List.of(number, givenSum - number));
                    Collections.sort(pair);
                    pairs.add(pair);
                }
            }
            integersByOccurrence.put(number, integersByOccurrence.getOrDefault(number, 0) + 1);
        }

        return pairs;
    }
}
