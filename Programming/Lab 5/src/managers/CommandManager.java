package managers;

import commands.Command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The CommandManager class is responsible for managing the commands.
 *
 * @author AlanTheKnight
 */
public class CommandManager {
    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ArrayList<String> history = new ArrayList<>();

    /**
     * Register a command.
     */
    public void register(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Get commands map.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Get history list.
     */
    public ArrayList<String> getHistory() {
        return history;
    }

    /**
     * Add command to history.
     */
    public void addToHistory(String command) {
        history.add(command);
    }

    /**
     * Get command by it's name
     */
    public Command getCommand(String name) {
        return commands.get(name);
    }
}
