package skazinski.szymon.task.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public List<List<Integer>> getPairs(List<Integer> integers) {
        return findPairs(integers).stream()
                .sorted(Comparator.comparingInt(o -> o.get(0)))
                .collect(Collectors.toList());
    }


    private List<List<Integer>> findPairs(List<Integer> integers) {
        List<List<Integer>> pairs = new LinkedList<>();

        for (int i = 0; i < integers.size(); i++) {
            Integer integer1 = integers.get(i);
            for (int j = i + 1; j < integers.size(); j++) {
                Integer integer2 = integers.get(j);
                if (integer1 + integer2 == 13) {
                    List<Integer> pair = new ArrayList<>();
                    if (integer1 < integer2){
                        pair.add(integer1);
                        pair.add(integer2);
                    } else {
                        pair.add(integer2);
                        pair.add(integer1);
                    }
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

}
