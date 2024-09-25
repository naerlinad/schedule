package view.consoleUI.commands.saverMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetCurrentPath extends Command {
    public GetCurrentPath(ConsoleUI consoleUI) {
        super("Show current path of data file saving", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getCurrentPath();
    }
}
