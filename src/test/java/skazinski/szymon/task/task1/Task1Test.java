package skazinski.szymon.task.task1;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Task1Test {

    @DataProvider
    public Object[][] basicMeasurementDataProvider() {
        return new Object[][]{
                {List.of(1, 10, 20, 20, 2, 5), new Measurements(List.of(1, 2, 5, 10, 20), 6, 5, 1, 20)},
                {List.of(8, 17, 15, 400, -8, 19,8,-8), new Measurements(List.of(-8,8,15,17,19,400), 8, 6, -8, 400)},
                {List.of(10,10,10), new Measurements(List.of(10), 3, 1, 10, 10)}
        };
    }

    @Test(dataProvider = "basicMeasurementDataProvider")
    public void basicMeasurementTest(List<Integer> input, Measurements expected) {
        Task1 task1 = new Task1();

        Measurements actual = task1.getBasicMeasurements(input);

        Assert.assertEquals(actual, expected);
    }

}
