package skazinski.szymon.task2;

import skazinski.szymon.utils.LineReader;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public void getPairs(InputStream inputStream) {
        LineReader lineReader = new LineReader(inputStream);
        String[] strings = lineReader.readLine();

        List<Integer> integers = Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<SortedSet<Integer>> pairs = getPairs(integers);

        String sorted = pairs.stream()
                .sorted(Comparator.comparingInt(SortedSet::first))
                .map(ints -> ints.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));

        System.out.println(sorted);
    }


    private List<SortedSet<Integer>> getPairs(List<Integer> integers) {
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

//zakladam ze liczby moga byc dodatnie i ujemne (gdyby byly tylko dodatnie to moznaby dodatkowo ograniczyc sprawdzanie liczb wiekszych od 0)
//uzylem LinkedList zamiast List zeby uniknac ciaglego powiekszania List
