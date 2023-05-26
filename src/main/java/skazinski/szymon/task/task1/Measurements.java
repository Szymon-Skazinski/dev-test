package skazinski.szymon.task.task1;

import java.util.List;
import java.util.Objects;

public class Measurements {
    private final List<Integer> distinctIntegers;
    private final int count;
    private final int distinct;
    private final int min;
    private final int max;

    public Measurements(List<Integer> distinctAndSortedList, int count, int distinct, int min, int max) {
        this.distinctIntegers = distinctAndSortedList;
        this.count = count;
        this.distinct = distinct;
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurements that = (Measurements) o;
        return count == that.count && distinct == that.distinct && min == that.min && max == that.max
                && distinctIntegers.equals(that.distinctIntegers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distinctIntegers, count, distinct, min, max);
    }

    @Override
    public String toString() {
        return listToString(distinctIntegers) + "\n" +
                "count: " + count + "\n" +
                "distinct: " + distinct + "\n" +
                "min: " + min + "\n" +
                "max: " + max;
    }

    private String listToString(List<Integer> integers) {
        return integers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }
}
