package utils;

import java.util.Scanner;

/**
 * Standart console.
 * 
 * @author AlanTheKnight
 */
public class StandartConsole implements Console {
    /**
     * The prompt entry
     */
    private static final String promptEntry = "$ ";

    /**
     * The file scanner
     */
    private static Scanner fileScanner = null;

    /**
     * The standard input scanner
     */
    private static Scanner stdInScanner = new Scanner(System.in);

    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    @Override
    public void printError(Object obj) {
        System.err.println(ConsoleColors.colorize("Error: ", ConsoleColors.RED) + obj);
    }

    @Override
    public String readln() {
        return readln(true);
    }

    @Override
    public String readln(boolean printPrompt) {
        if (printPrompt)
            print(promptEntry);
        return (fileScanner != null ? fileScanner : stdInScanner).nextLine();
    }

    @Override
    public boolean canReadln() {
        return (fileScanner != null ? fileScanner : stdInScanner).hasNextLine();
    }

    @Override
    public void printTwoColumns(Object left, Object right, String separator, int leftWidth) {
        System.out.printf("%-" + leftWidth + "s %s %s%n", left, separator, right);
    }

    @Override
    public void printTwoColumns(Object left, Object right, String separator) {
        System.out.printf("%-40s %s %s%n", left, separator, right, 30);
    }

    @Override
    public void selectFileScanner(Scanner obj) {
        fileScanner = obj;
    }

    @Override
    public void printSuccess(String s) {
        System.out.println(ConsoleColors.GREEN + s + ConsoleColors.RESET);
    }

    @Override
    public void printInColor(ConsoleColors color, Object obj) {
        println(ConsoleColors.colorize(obj.toString(), color));
    }

    @Override
    public boolean isInteractive() {
        return fileScanner == null;
    }
}
