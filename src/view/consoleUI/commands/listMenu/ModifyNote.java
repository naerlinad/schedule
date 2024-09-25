package view.consoleUI.commands.listMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;

public class ModifyNote extends Command {

    public ModifyNote(ConsoleUI consoleUI) {
        super("Choose and modify", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getById();
    }
}
