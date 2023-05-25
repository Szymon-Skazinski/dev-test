package skazinski.szymon.task1;

import skazinski.szymon.utils.LineReader;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    public void getMeasurements(InputStream inputStream) {
        LineReader lineReader = new LineReader(inputStream);
        String[] strings = lineReader.readLine();

        int count = strings.length;

        List<Integer> integers = Arrays.stream(strings)
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        int distinctCount = integers.size();
        Integer min = integers.get(0);
        Integer max = integers.get(distinctCount - 1);

        String integersString = listToString(integers);

        printOutput(count, distinctCount, min, max, integersString);
    }

    private String listToString(List<Integer> integers) {
        return integers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }

    private void printOutput(int count, int distinctCount, Integer min, Integer max, String integersString) {
        String output = integersString + "\n" +
                "count: " + count + "\n" +
                "distinct: " + distinctCount + "\n" +
                "min: " + min + "\n" +
                "max: " + max;

        System.out.println(output);
    }

}
