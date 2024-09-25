package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetForLastWeek extends Command {


    public GetForLastWeek(ConsoleUI consoleUI) {
        super("Get schedule for last week", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getForLastWeek();
    }
}
