package view.consoleUI.commands.listMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetSortedByPriority extends Command {
    public GetSortedByPriority(ConsoleUI consoleUI) {
        super("Sort by priority", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getSortedByPriority();
    }
}
