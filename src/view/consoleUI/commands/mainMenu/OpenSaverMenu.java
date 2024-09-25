package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class OpenSaverMenu extends Command {
    public OpenSaverMenu(ConsoleUI consoleUI) {
        super("Save or load application data", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().openSaverMenu();
    }
}
