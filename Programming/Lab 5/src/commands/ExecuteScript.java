package commands;

/**
 * Command for executing a script from a file.
 * <p>
 * (the logic behind this command is implemented in {@link
 * commands.CommandRunner})
 *
 * @author AlanTheKnight
 */
public class ExecuteScript extends Command {
    public ExecuteScript() {
        super("execute_script", "Считать и исполнить скрипт из указанного файла", "execute_script <filename>");
    }

    @Override
    public boolean execute(String[] arguments) {
        return true;
    }
}
