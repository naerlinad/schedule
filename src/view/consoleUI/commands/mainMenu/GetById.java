package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetById extends Command {

    public GetById(ConsoleUI consoleUI) {
        super("Find note by its id", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getById();
    }
}
