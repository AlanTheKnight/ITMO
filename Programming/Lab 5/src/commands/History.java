package commands;

import managers.CommandManager;
import utils.Console;
import utils.ConsoleColors;

import java.util.ArrayList;

/**
 * Command for displaying the history of commands (last 13 used).
 */
public class History extends ConsoleCmdCommand {
    /**
     * Constructor for the command.
     *
     * @param console        console
     * @param commandManager command manager
     */
    public History(Console console, CommandManager commandManager) {
        super("history", "Вывести историю команд", "history", console, commandManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        ArrayList<String> history = commandManager.getHistory();
        console.printInColor(ConsoleColors.BLUE, "История команд:");

        for (int i = history.size() - 1; i >= Math.max(0, history.size() - 13); i--) {
            console.println(history.get(i));
        }

        return true;
    }
}
