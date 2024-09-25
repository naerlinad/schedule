package view.consoleUI.commands.saverMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetPathOfDataFile extends Command {


    public SetPathOfDataFile(ConsoleUI consoleUI) {
        super("Set new path for application's data file", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setPathOfDataFile();
    }
}
