package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetNotesTitle extends Command {

    public SetNotesTitle(ConsoleUI consoleUI) {
        super("Change the title", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setNotesTitle();
    }
}
