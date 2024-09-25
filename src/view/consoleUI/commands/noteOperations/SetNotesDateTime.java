package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetNotesDateTime extends Command {

    public SetNotesDateTime(ConsoleUI consoleUI) {
        super("Change the main date and time", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setNotesDateTime();
    }
}
