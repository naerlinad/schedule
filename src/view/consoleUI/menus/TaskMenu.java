package view.consoleUI.menus;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.BackMainMenu;
import view.consoleUI.commands.Command;
import view.consoleUI.commands.noteOperations.*;
import view.consoleUI.commands.taskMenu.SwitchTasksStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMenu {
    List<Command> commands;

    public TaskMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new SetNotesTitle(consoleUI));
        commands.add(new SetNotesDateTime(consoleUI));
        commands.add(new SwitchTasksStatus(consoleUI));
        commands.add(new SetHighPriority(consoleUI));
        commands.add(new SetDramaticPriority(consoleUI));
        commands.add(new SetDefaultPriority(consoleUI));
        commands.add(new Remove(consoleUI));
        commands.add(new BackMainMenu(consoleUI));
    }

    public void menu() {
        System.out.println("\nTask modifier menu:");
        for (int i = 0; i < commands.size(); i++) {
            String str = String.format("%d -- %s", i + 1, commands.get(i).getDescription());
            System.out.println(str);
        }
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }
}
