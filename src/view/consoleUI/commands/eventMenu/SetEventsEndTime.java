package view.consoleUI.commands.eventMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetEventsEndTime extends Command {
    public SetEventsEndTime(ConsoleUI consoleUI) {
        super("Set the event's end time", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setEventsEndTime();
    }
}
