package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetByDateRange extends Command {

    public GetByDateRange(ConsoleUI consoleUI) {
        super("Get schedule for date range", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getByDateRange();
    }
}
