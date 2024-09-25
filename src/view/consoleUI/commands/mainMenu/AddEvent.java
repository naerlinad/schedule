package view.consoleUI.commands.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class AddEvent extends Command {

    public AddEvent(ConsoleUI consoleUI) {
        super("Add event", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addEvent();
    }
}
