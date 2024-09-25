package view.consoleUI.commands.saverMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SaveAppData extends Command {
    public SaveAppData(ConsoleUI consoleUI) {
        super("Save application data to current path", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveAppData();
    }
}
