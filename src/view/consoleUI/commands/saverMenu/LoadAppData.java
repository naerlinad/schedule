package view.consoleUI.commands.saverMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class LoadAppData extends Command {

    public LoadAppData(ConsoleUI consoleUI) {
        super("Load application data from current path", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadAppData();
    }
}
