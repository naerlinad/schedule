package view.consoleUI.menus;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;
import view.consoleUI.commands.BackMainMenu;
import view.consoleUI.commands.saverMenu.GetCurrentPath;
import view.consoleUI.commands.saverMenu.LoadAppData;
import view.consoleUI.commands.saverMenu.SaveAppData;
import view.consoleUI.commands.saverMenu.SetPathOfDataFile;

import java.util.ArrayList;
import java.util.List;

public class SaverMenu {
    List<Command> commands;

    public SaverMenu (ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new SaveAppData(consoleUI));
        commands.add(new LoadAppData(consoleUI));
        commands.add(new SetPathOfDataFile(consoleUI));
        commands.add(new GetCurrentPath(consoleUI));
        commands.add(new BackMainMenu(consoleUI));
    }

    public void menu() {
        System.out.println("\nSaver submenu:");
        for (int i = 0; i < commands.size(); i++) {
            String str = String.format("%d -- %s", i+1, commands.get(i).getDescription());
            System.out.println(str);
        }
    }

    public void execute (int choice) {
        commands.get(choice - 1).execute();
    }
}
