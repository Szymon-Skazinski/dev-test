package skazinski.szymon.task2;

import skazinski.szymon.utils.LineReader;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public List<Integer> getPairs(InputStream inputStream) {
        LineReader lineReader = new LineReader(inputStream);
        String[] strings = lineReader.readLine();

        List<Integer> integers = Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return findPairs(integers).stream()
                .sorted(Comparator.comparingInt(SortedSet::first))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


    private List<SortedSet<Integer>> findPairs(List<Integer> integers) {
        List<SortedSet<Integer>> pairs = new LinkedList<>();

        for (int i = 0; i < integers.size(); i++) {
            Integer integer1 = integers.get(i);
            for (int j = i + 1; j < integers.size(); j++) {
                Integer integer2 = integers.get(j);
                if (integer1 + integer2 == 13) {
                    SortedSet<Integer> pair = new TreeSet<>();
                    pair.add(integer1);
                    pair.add(integer2);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

}
