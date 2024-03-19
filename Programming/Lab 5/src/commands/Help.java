package commands;

import managers.CommandManager;
import utils.Console;
import utils.ConsoleColors;

/**
 * Command for displaying help for available commands.
 *
 * @author AlanTheKnight
 */
public class Help extends ConsoleCmdCommand {
    /**
     * Constructor for the command.
     *
     * @param console        console
     * @param commandManager command manager
     */
    public Help(Console console, CommandManager commandManager) {
        super("help", "Вывести справку по доступным командам", "help", console, commandManager);
    }

    @Override
    public boolean execute(String[] arguments) {
        console.printInColor(ConsoleColors.BLUE, "Список доступных команд:");
        commandManager.getCommands().values()
                .forEach(command -> console.printTwoColumns(command.getName(), command.getDescription(), " — ", 20));
        return true;
    }

}
