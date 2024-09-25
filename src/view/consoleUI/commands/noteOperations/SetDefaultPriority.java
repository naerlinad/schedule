package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetDefaultPriority extends Command {
    public SetDefaultPriority(ConsoleUI consoleUI) {
        super("Set default priority", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setDefaultPriority();
    }
}
