package utils;

/**
 * Interface for commands that can be executed.
 *
 * @author AlanTheKnight
 */
public interface Executable {
    /**
     * Execute the command with the given arguments.
     *
     * @param arguments arguments for the command
     * @return true if the command was executed successfully, false otherwise
     */
    boolean execute(String[] arguments);
}
