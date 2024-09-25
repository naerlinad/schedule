package presenter;

import model.service.Service;
import view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addEvent(String title, String strStartTime, String strEndTime) {
        String answer = service.addEvent(title, strStartTime, strEndTime);
        view.print(answer);
    }

    public void addTask(String title, String strDeadline) {
        String answer = service.addTask(title, strDeadline);
        view.print(answer);
    }

    public void remove(int id) {
        String answer = service.remove(id);
        view.print(answer);
    }

    public void getById(int id) {
        String answer = service.getById(id);
        view.print(answer);
    }

    public void getByDate(String strDate) {
        String answer = service.getByDate(strDate);
        view.print(answer);
    }

    public void getByDateRange(String strDate1, String strDate2) {
        String answer = service.getByDateRange(strDate1, strDate2);
        view.print(answer);
    }

    public void getForToday() {
        String answer = service.getForToday();
        view.print(answer);
    }

    public void getForThisWeek() {
        String answer = service.getForThisWeek();
        view.print(answer);
    }

    public void getForNextWeek() {
        String answer = service.getForNextWeek();
        view.print(answer);
    }

    public void getForLastWeek() {
        String answer = service.getForLastWeek();
        view.print(answer);
    }

    public void getAllNotes() {
        String answer = service.getAllNotes();
        view.print(answer);
    }

    public void getSortedByTime() {
        String answer = service.getSortedByTime();
        view.print(answer);
    }

    public void getSortedByPriority() {
        String answer = service.getSortedByPriority();
        view.print(answer);
    }

    public void saveAppData() {
        String answer = service.saveAppData();
        view.print(answer);
    }

    public void loadAppData() {
        String answer = service.loadAppData();
        view.print(answer);
    }

    public void setPathOfDataFile (String path) {
        String answer = service.setPathOfDataFile(path);
        view.print(answer);
    }

    public void getCurrentPath() {
        String answer = service.getCurrentPath();
        view.print(answer);
    }

    public void setNotesTitle(int id, String title) {
        String answer = service.setNotesTitle(id, title);
        view.print(answer);
    }

    public void setNotesDateTime(int id, String strDateTime) {
        String answer = service.setNotesDateTime(id, strDateTime);
        view.print(answer);
    }

    public void setDefaultPriority(int id) {
        String answer = service.setDefaultPriority(id);
        view.print(answer);
    }

    public void setHighPriority(int id) {
        String answer = service.setHighPriority(id);
        view.print(answer);
    }

    public void setDramaticPriority(int id) {
        String answer = service.setDramaticPriority(id);
        view.print(answer);
    }

    public void setEventsEndTime(int id, String strEndTime) {
        String answer = service.setEventsEndTime(id, strEndTime);
        view.print(answer);
    }

    public void switchTasksStatus(int id) {
        String answer = service.switchTasksStatus(id);
        view.print(answer);
    }

    public void getNotesType(int id) {
        String answer = service.getNotesType(id);
        view.receiveTypeInfo(answer);
    }
}
