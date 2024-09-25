package view.consoleUI.menus;

import view.consoleUI.ConsoleUI;
import view.consoleUI.commands.Command;
import view.consoleUI.commands.mainMenu.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddEvent(consoleUI));
        commands.add(new AddTask(consoleUI));
        commands.add(new GetAllNotes(consoleUI));
        commands.add(new GetByDate(consoleUI));
        commands.add(new GetByDateRange(consoleUI));
        commands.add(new GetForThisWeek(consoleUI));
        commands.add(new GetForNextWeek(consoleUI));
        commands.add(new GetForLastWeek(consoleUI));
        commands.add(new GetForToday(consoleUI));
        commands.add(new GetById(consoleUI));
        commands.add(new OpenSaverMenu(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public void menu() {
        System.out.println("\nMain menu:");
        for (int i = 0; i < commands.size(); i++) {
            String str = String.format("%d -- %s", i+1, commands.get(i).getDescription());
            System.out.println(str);
        }
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }
}
