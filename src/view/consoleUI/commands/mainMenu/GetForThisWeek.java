package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetForThisWeek extends Command {

    public GetForThisWeek(ConsoleUI consoleUI) {
        super("Get schedule for this week", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getForThisWeek();
    }
}
