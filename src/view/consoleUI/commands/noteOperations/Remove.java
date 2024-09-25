package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class Remove extends Command {
    public Remove(ConsoleUI consoleUI) {
        super("Remove", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().remove();
    }
}
