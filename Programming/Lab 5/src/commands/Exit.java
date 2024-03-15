package commands;

import utils.Console;

/**
 * Command for stopping the program without saving to file.
 * 
 * @author AlanTheKnight
 */
public class Exit extends ConsoleCommand {
    /**
     * Constructor for the command.
     * @param console console
     */
    public Exit(Console console) {
        super("exit", "Завершить программу (без сохранения в файл)", "exit", console);
    }

    @Override
    public boolean execute(String[] arguments) {
        if (arguments.length != 1) {
            printInvalidArgs(console);
            return false;
        }

        console.printSuccess("Завершение программы...");
        System.exit(0);
        return true;
    }
}
