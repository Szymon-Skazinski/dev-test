package skazinski.szymon.task.task1;

import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    public Measurements getBasicMeasurements(List<Integer> integers) {
        int count = integers.size();

        List<Integer> sortedAndDistinct = integers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        int distinctCount = sortedAndDistinct.size();
        Integer min = sortedAndDistinct.get(0);
        Integer max = sortedAndDistinct.get(distinctCount - 1);

        return new Measurements(sortedAndDistinct,count,distinctCount,min,max);
    }

}
