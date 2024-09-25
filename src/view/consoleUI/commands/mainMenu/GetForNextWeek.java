package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetForNextWeek extends Command {

    public GetForNextWeek(ConsoleUI consoleUI) {
        super("Get schedule for next week", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getForNextWeek();
    }
}
