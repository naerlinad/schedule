package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class AddTask extends Command {

    public AddTask(ConsoleUI consoleUI) {
        super("Add task", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addTask();
    }
}
