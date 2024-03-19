import commands.*;
import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;
import utils.StandartConsole;

public class Main {
    public static void main(String[] args) {
        var console = new StandartConsole();

        if (args.length == 0) {
            console.printError("Не указан файл с данными.");
            return;
        }

        var dumpManager = new DumpManager(args[0], console);
        var collectionManager = new CollectionManager(dumpManager);
        collectionManager.loadCollection();

        var commandManager = new CommandManager() {
            {
                register(new Exit(console));
                register(new History(console, this));
                register(new Help(console, this));
                register(new Save(console, collectionManager));
                register(new Show(console, collectionManager));
                register(new RemoveKey(console, collectionManager));
                register(new Show(console, collectionManager, "print_ascending",
                        "Вывести элементы коллекции в порядке возрастания"));
                register(new Clear(console, collectionManager));
                register(new Info(console, collectionManager));
                register(new RemoveGreaterKey(console, collectionManager));
                register(new FilterByEndDate(console, collectionManager));
                register(new RemoveAnyByEndDate(console, collectionManager));
                register(new ExecuteScript());
                register(new Insert(console, collectionManager));
                register(new Update(console, collectionManager));
                register(new RemoveGreater(console, collectionManager));
            }
        };

        var commandRunner = new CommandRunner(console, commandManager);
        commandRunner.run();
    }
}
