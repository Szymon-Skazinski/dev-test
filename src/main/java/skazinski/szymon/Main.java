package skazinski.szymon;

import skazinski.szymon.runner.Task1Runner;
import skazinski.szymon.runner.Task2Runner;
import skazinski.szymon.runner.Task3Runner;
import skazinski.szymon.runner.TaskRunner;
import skazinski.szymon.utils.CommandLinePrinter;
import skazinski.szymon.utils.CommandLineReader;

public class Main {

    public static void main(String[] args) {

        CommandLineReader reader = new CommandLineReader(System.in);
        System.out.println("Please provide number of task: ");
        System.out.println("1. Task 1");
        System.out.println("2. Task 2");
        System.out.println("3. Task 3");
        int taskNumber = reader.readNextInt();

        while (taskNumber < 1 || taskNumber > 3) {
            taskNumber = reader.readNextInt();
        }

        CommandLinePrinter printer = new CommandLinePrinter();
        TaskRunner runner;
        switch (taskNumber) {
            case 1:
                runner = new Task1Runner(System.in, printer);
                break;
            case 2:
                runner = new Task2Runner(System.in, printer);
                break;
            default:
                runner = new Task3Runner(System.in, printer);
                break;
        }
        runner.runTask();

    }

}
