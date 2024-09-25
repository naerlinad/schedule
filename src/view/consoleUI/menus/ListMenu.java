package view.consoleUI.menus;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;
import view.consoleUI.commands.BackMainMenu;
import view.consoleUI.commands.listMenu.GetSortedByPriority;
import view.consoleUI.commands.listMenu.GetSortedByTime;
import view.consoleUI.commands.listMenu.ModifyNote;

import java.util.ArrayList;
import java.util.List;

public class ListMenu {
    List<Command> commands;

    public ListMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new GetSortedByTime(consoleUI));
        commands.add(new GetSortedByPriority(consoleUI));
        commands.add(new ModifyNote(consoleUI));
        commands.add(new BackMainMenu(consoleUI));
    }

    public void menu() {
        System.out.println("\nSubmenu:");
        for (int i = 0; i < commands.size(); i++) {
            String str = String.format("%d -- %s", i+1, commands.get(i).getDescription());
            System.out.println(str);
        }
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }
}
