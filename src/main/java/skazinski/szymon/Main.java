package skazinski.szymon;

import skazinski.szymon.runner.Task1Runner;
import skazinski.szymon.runner.Task2Runner;
import skazinski.szymon.runner.Task3Runner;
import skazinski.szymon.runner.TaskRunner;
import skazinski.szymon.utils.CommandLinePrinter;
import skazinski.szymon.utils.CommandLineReader;
import skazinski.szymon.utils.Printer;
import skazinski.szymon.utils.Reader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Reader reader = new CommandLineReader();
        Printer printer = new CommandLinePrinter();

        printer.printLine("1. Task 1");
        printer.printLine("2. Task 2");
        printer.printLine("3. Task 3");
        Scanner scanner = new Scanner(System.in);
        int taskNumber = 0;

        while (taskNumber < 1 || taskNumber > 3) {
            printer.printLine("Please provide number of task: ");
            taskNumber = scanner.nextInt();
        }

        TaskRunner runner;
        switch (taskNumber) {
            case 1:
                runner = new Task1Runner(reader, printer);
                break;
            case 2:
                runner = new Task2Runner(reader, printer);
                break;
            default:
                runner = new Task3Runner(reader, printer);
                break;
        }
        runner.runTask();

    }

}
