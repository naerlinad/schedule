package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetForToday extends Command {
    public GetForToday(ConsoleUI consoleUI) {
        super("Get schedule for today", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getForToday();
    }
}
