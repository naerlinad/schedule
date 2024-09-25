package view.consoleUI.commands.taskMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SwitchTasksStatus extends Command {

    public SwitchTasksStatus(ConsoleUI consoleUI) {
        super("Switch the task's status", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().switchTasksStatus();
    }
}
