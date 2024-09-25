package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetAllNotes extends Command {

    public GetAllNotes(ConsoleUI consoleUI) {
        super("Get list of all notes", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAllNotes();
    }
}
