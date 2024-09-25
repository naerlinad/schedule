package view.consoleUI.commands.noteOperations;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class SetDramaticPriority extends Command {

    public SetDramaticPriority(ConsoleUI consoleUI) {
        super("Set dramatic priority", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setDramaticPriority();
    }
}
