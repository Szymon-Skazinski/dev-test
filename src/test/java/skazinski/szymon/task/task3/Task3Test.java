package skazinski.szymon.task.task3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Task3Test {

    @DataProvider
    public Object[][] getNumberOfGraphsDataProvider() {

        return new Object[][]{
                {List.of(List.of(2, 3), List.of(1, 2), List.of(5, 6)), 2},
                {List.of(List.of(1, 2), List.of(2, 3), List.of(4, 5)), 2},
                {List.of(List.of(3, 4), List.of(1, 2), List.of(2, 3), List.of(4, 5)), 1},
                {List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6)), 3},
                {List.of(List.of(1, 6), List.of(5, 6)), 1},
                {List.of(List.of(1, 6), List.of(4, 5), List.of(5, 6), List.of(3, 4), List.of(1, 2)), 1},
                {List.of(List.of(1, 4), List.of(3, 4), List.of(2,3)), 1},
        };
    }

    @Test(dataProvider = "getNumberOfGraphsDataProvider")
    public void getNumberOfGraphsTest(List<List<Integer>> pairs, int expected) {
        Task3 task3 = new Task3();

        int actual = task3.getNumberOfGraphs(pairs);

        Assert.assertEquals(actual, expected);
    }
}
