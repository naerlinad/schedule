package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class GetByDate extends Command {

    public GetByDate(ConsoleUI consoleUI) {
        super("Get schedule for certain date", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getByDate();
    }
}
