package view.consoleUI.commands.listMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetSortedByTime extends Command {
    public GetSortedByTime(ConsoleUI consoleUI) {
        super("Sort by time", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getSortedByTime();
    }
}
