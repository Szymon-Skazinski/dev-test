package skazinski.szymon.task.task2;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class Task2Test {

    @DataProvider
    public Object[][] getPairsDataProvider() {
        return new Object[][]{
                {List.of(1, 2, 10, 7, 5, 3, 6, 6, 13, 0), 13,
                        List.of(List.of(0, 13), List.of(3, 10), List.of(6, 7), List.of(6, 7))
                },
                {List.of(1, 2, 10, 7, 5, 3, 6, 13, 0), 13,
                        List.of(List.of(0, 13), List.of(3, 10), List.of(6, 7))
                },
                {List.of(-7, 20, 10, 5, 7, 3, 6, 6, 0, 13), 13,
                        List.of(List.of(-7, 20), List.of(0, 13), List.of(3, 10), List.of(6, 7), List.of(6, 7))
                },
                {List.of(-7, 20, 10, 5, 7, 3, 7, 6, 6, 0, 13), 13,
                        List.of(List.of(-7, 20), List.of(0, 13), List.of(3, 10), List.of(6, 7), List.of(6, 7), List.of(6, 7), List.of(6, 7))
                },
                {List.of(2, 2, 8, 1, 9, 3), 13, Collections.EMPTY_LIST},
                {List.of(5, 5, 5, 5), 10,
                        List.of(List.of(5, 5), List.of(5, 5), List.of(5, 5), List.of(5, 5), List.of(5, 5), List.of(5, 5))
                },
        };
    }

    @Test(dataProvider = "getPairsDataProvider")
    public void getPairsTest(List<Integer> input, int givenSum, List<List<Integer>> expected) {
        Task2 task2 = new Task2();

        List<List<Integer>> actual = task2.getPairs(input, givenSum);

        Assert.assertEquals(actual, expected);
    }
}
