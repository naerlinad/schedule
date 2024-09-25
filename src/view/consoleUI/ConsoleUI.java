package view.consoleUI;

import presenter.Presenter;
import view.View;
import view.consoleUI.menus.*;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private int currentId;
    private String currentType;
    private boolean work;
    private Presenter presenter;

    private MainMenu mainMenu;
    private ListMenu listMenu;
    private SaverMenu saverMenu;
    private EventMenu eventMenu;
    private TaskMenu taskMenu;

    public ConsoleUI() {
        currentId = -1;
        currentType = "";
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);

        mainMenu = new MainMenu(this);
        listMenu = new ListMenu(this);
        saverMenu = new SaverMenu(this);
        eventMenu = new EventMenu(this);
        taskMenu = new TaskMenu(this);
    }


    @Override
    public void start() {
        loadAppData();
        System.out.println("\nGreetings");
        while(work) {
            openMainMenu();
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        saveAppData();
        System.out.println("\nFarewell");
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }

    @Override
    public void receiveTypeInfo(String type) {
        currentType = type;
    }

    public void addEvent() {
        System.out.println("Enter a title for the event");
        String title = scanner.nextLine();

        System.out.println("Enter the date and time of its beginning. Use the format like this:\t2024-10-28t18:00");
        String startTime = scanner.nextLine();

        System.out.println("Enter the date and time of the event's ending. Or if there is no certainty about it, just enter nothing");
        String entTime = scanner.nextLine();
        presenter.addEvent(title, startTime, entTime);
    }

    public void addTask() {
        System.out.println("Enter a title for the task");
        String title = scanner.nextLine();

        System.out.println("Enter the date and time of its deadline. Use the format like this:\t2024-10-28t18:00");
        String deadline = scanner.nextLine();
        presenter.addTask(title, deadline);
    }

    public void remove() {
        presenter.remove(currentId);
    }

    public void getById() {
        System.out.println("Enter note's id");
        try {
            String input = scanner.nextLine();
            currentId = Integer.parseInt(input);
            getByCurrentId();
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void getByCurrentId(){
        presenter.getById(currentId);
        presenter.getNotesType(currentId);
        if(currentType.equals("Event")) {
            openEventMenu();
        } else if (currentType.equals("Task")) {
            openTaskMenu();
        }
    }

    public void getByDate() {
        System.out.println("Enter the date. Use format like this:\t2024-10-28");
        String date = scanner.nextLine();
        presenter.getByDate(date);
        openListMenu();
    }

    public void getByDateRange() {
        System.out.println("Enter the first date of the required range. Use format like this:\t2024-10-28");
        String date1 = scanner.nextLine();
        System.out.println("Enter the second date");
        String date2 = scanner.nextLine();
        presenter.getByDateRange(date1, date2);
        openListMenu();
    }

    public void getForToday() {
        presenter.getForToday();
        openListMenu();
    }

    public void getForThisWeek() {
        presenter.getForThisWeek();
        openListMenu();
    }

    public void getForNextWeek() {
        presenter.getForNextWeek();
        openListMenu();
    }

    public void getForLastWeek() {
        presenter.getForLastWeek();
        openListMenu();
    }

    public void getAllNotes() {
        presenter.getAllNotes();
        openListMenu();
    }

    public void getSortedByTime() {
        presenter.getSortedByTime();
        openListMenu();
    }

    public void getSortedByPriority() {
        presenter.getSortedByPriority();
        openListMenu();
    }

    public void saveAppData() {
        presenter.saveAppData();
    }

    public void loadAppData() {
        presenter.loadAppData();
    }

    public void setPathOfDataFile() {
        System.out.println("Enter the file's name and path where the data file should be saved or loaded from");
        String path = scanner.nextLine();
        presenter.setPathOfDataFile(path);
        openSaverMenu();
    }

    public void getCurrentPath() {
        presenter.getCurrentPath();
        openSaverMenu();
    }

    public void setNotesTitle() {
        System.out.println("Enter new title to set");
        String title = scanner.nextLine();
        presenter.setNotesTitle(currentId, title);
        getByCurrentId();
    }

    public void setNotesDateTime() {
        System.out.println("Enter the new date and time to set");
        String dateTime = scanner.nextLine();
        presenter.setNotesDateTime(currentId, dateTime);
        getByCurrentId();
    }

    public void setDefaultPriority() {
        presenter.setDefaultPriority(currentId);
        getByCurrentId();
    }

    public void setHighPriority() {
        presenter.setHighPriority(currentId);
        getByCurrentId();
    }

    public void setDramaticPriority() {
        presenter.setDramaticPriority(currentId);
        getByCurrentId();
    }

    public void setEventsEndTime() {
        System.out.println("Enter the new date and time to set as the event's end time. Use format like this:\t2024-10-28t18:00." +
                "\nOr enter nothing to remove those currently set");
        String endTime = scanner.nextLine();
        presenter.setEventsEndTime(currentId, endTime);
        getByCurrentId();
    }

    public void switchTasksStatus() {
        presenter.switchTasksStatus(currentId);
        getByCurrentId();
    }

    public void openMainMenu() {
        mainMenu.menu();
        String strChoice = scanner.nextLine();
        try {
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void openListMenu() {
        listMenu.menu();
        String strChoice = scanner.nextLine();
        try {
            int choice = Integer.parseInt(strChoice);
            listMenu.execute(choice);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void openSaverMenu() {
        saverMenu.menu();
        String strChoice = scanner.nextLine();
        try {
            int choice = Integer.parseInt(strChoice);
            saverMenu.execute(choice);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void openEventMenu() {
        eventMenu.menu();
        String strChoice = scanner.nextLine();
        try {
            int choice = Integer.parseInt(strChoice);
            eventMenu.execute(choice);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public void openTaskMenu() {
        taskMenu.menu();
        String strChoice = scanner.nextLine();
        try {
            int choice = Integer.parseInt(strChoice);
            taskMenu.execute(choice);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

}
