package view.consoleUI.commands;

import view.consoleUI.ConsoleUI;

public class BackMainMenu extends Command {
    public BackMainMenu(ConsoleUI consoleUI) {
        super("Go back to main menu", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().openMainMenu();
    }
}
