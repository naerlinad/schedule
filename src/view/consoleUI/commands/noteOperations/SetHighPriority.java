package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetHighPriority extends Command {

    public SetHighPriority(ConsoleUI consoleUI) {
        super("Set high priority", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setHighPriority();
    }
}
