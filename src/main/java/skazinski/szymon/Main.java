package skazinski.szymon;

import skazinski.szymon.runner.Task1Runner;
import skazinski.szymon.runner.Task2Runner;
import skazinski.szymon.runner.Task3Runner;
import skazinski.szymon.runner.TaskRunner;
import skazinski.szymon.util.printer.CommandLinePrinter;
import skazinski.szymon.util.reader.CommandLineReader;
import skazinski.szymon.util.printer.Printer;
import skazinski.szymon.util.reader.Reader;

import java.util.Scanner;

public class Main {

    private static final Printer printer = new CommandLinePrinter();
    private static final Reader reader = new CommandLineReader();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            int taskNumber = getTaskNumber();
            runTask(taskNumber);
            printer.printLine("Do you want to run another task? (y/n).");
        } while (!scanner.next().equalsIgnoreCase("n"));
    }

    private static void runTask(int taskNumber) {
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

    private static int getTaskNumber() {
        printer.printLine("1. Task 1");
        printer.printLine("2. Task 2");
        printer.printLine("3. Task 3");
        Scanner scanner = new Scanner(System.in);
        int taskNumber = 0;

        while (taskNumber < 1 || taskNumber > 3) {
            printer.printLine("Please provide number of task: ");
            taskNumber = scanner.nextInt();
        }
        return taskNumber;
    }

}
