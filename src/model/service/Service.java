package model.service;

import model.comparators.DateTimeComparator;
import model.comparators.PriorityComparator;
import model.schedule.Schedule;
import model.notes.Event;
import model.notes.Note;
import model.notes.Task;
import model.writers.Serializer;
import model.writers.Writer;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Service implements Serializable {
    private Schedule schedule;
    private Writer writer;

    public Service() {
        schedule = new Schedule();
        writer = new Serializer();
    }

    public String addEvent(String title, String strStartTime, String strEndTime) {
        try {
            LocalDateTime startTime = LocalDateTime.parse(strStartTime);
            LocalDateTime endTime = null;
            if (!strEndTime.isEmpty()) endTime = LocalDateTime.parse(strEndTime);
            Event event = new Event(title, startTime, endTime);
            if (!schedule.add(event)) return "Unexpected error";
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Event was scheduled";
    }

    public String addTask(String title, String strDeadline) {
        try {
            LocalDateTime deadline = LocalDateTime.parse(strDeadline);
            Task task = new Task(title, deadline);
            if (!schedule.add(task)) return "Unexpected error";
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Task was scheduled";
    }

    public String remove(int id) {
        if (!schedule.remove(id)) return "Unexpected error";
        return String.format("Entry with id '%d' was removed", id);
    }

    public String getById(int id) {
        Note note = schedule.getById(id);
        if (note == null) return String.format("Entry with id '%d' was not found", id);
        return note.toString();
    }

    public String getByDate(String strDate) {
        try {
            LocalDate date = LocalDate.parse(strDate);
            String str = schedule.getByDate(date);
            if (str.isEmpty()) return "Nothing was scheduled for this date";
            return str;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getByDateRange(String strDate1, String strDate2) {
        try {
            LocalDate date1 = LocalDate.parse(strDate1);
            LocalDate date2 = LocalDate.parse(strDate2);
            String str = schedule.getByDateRange(date1, date2);
            if (str.isEmpty()) return "Nothing was scheduled for this date range";
            return str;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getForToday() {
        String str = schedule.getForToday();
        if (str.isEmpty()) return "Nothing was scheduled for today";
        return str;
    }

    public String getForThisWeek() {
        String str = schedule.getForThisWeek();
        if (str.isEmpty()) return "Nothing was scheduled for this week";
        return str;
    }

    public String getForNextWeek() {
        String str = schedule.getForNextWeek();
        if (str.isEmpty()) return "Nothing was scheduled for that week";
        return str;
    }

    public String getForLastWeek() {
        String str = schedule.getForLastWeek();
        if (str.isEmpty()) return "Nothing was scheduled for that week";
        return str;
    }

    public String getAllNotes() {
        String str = schedule.getAllNotes();
        if (str.isEmpty()) return "Schedule is empty";
        return str;
    }

    public String getSortedByTime() {
        return schedule.getSorted(new DateTimeComparator());
    }

    public String getSortedByPriority() {
        return schedule.getSorted(new PriorityComparator());
    }

    // further are methods 'applications data handlers'

    public String saveAppData() {
        try {
            writer.write(schedule);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Data was saved";
    }

    public String loadAppData() {
        try {
            schedule = (Schedule) writer.read();
        } catch (IOException | ClassNotFoundException e) {
            return e.getMessage();
        }
        return "Data was loaded";
    }

    public String setPathOfDataFile (String path) {
        writer.setPath(path);
        if(path.isEmpty()) return String.format("Path was set to default value '%s'", writer.getPath());
        return String.format("Path was changed to '%s'", writer.getPath());
    }

    public String getCurrentPath() {
        return writer.getPath();
    }

    // further are methods 'note modifiers'

    public String setNotesTitle(int id, String title) {
        Note note = schedule.getById(id);
        if (note == null) return "By this id nothing was found";
        note.setTitle(title);
        return "Title was changed";
    }

    public String setNotesDateTime(int id, String strDateTime) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(strDateTime);
            Note note = schedule.getById(id);
            note.setDateTime(dateTime);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Date and time was changed";
    }

    public String setDefaultPriority(int id) {
        Note note = schedule.getById(id);
        if (note == null) return "By this id nothing was found";
        note.setDefaultPriority();
        return "Default priority was set";
    }

    public String setHighPriority(int id) {
        Note note = schedule.getById(id);
        if (note == null) return "By this id nothing was found";
        note.setHighPriority();
        return "High priority was set";
    }

    public String setDramaticPriority(int id) {
        Note note = schedule.getById(id);
        if (note == null) return "By this id nothing was found";
        note.setDramaticPriority();
        return "Dramatic priority was set";
    }

    public String setEventsEndTime(int id, String strEndTime) {
        try {
            LocalDateTime endTime = LocalDateTime.parse(strEndTime);
            Event event = (Event) schedule.getById(id);
            if (event.getDateTime().isAfter(endTime)) return "End time cannot be earlier than start time";
            event.setEndTime(endTime);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "End time was changed";
    }

    public String switchTasksStatus(int id) {
        try {
            Task task = (Task) schedule.getById(id);
            task.switchStatus();
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Task status was switched";
    }

    public String getNotesType(int id) {
        Note entry = schedule.getById(id);
        if (entry == null) return "";
        return entry.getClass().getSimpleName();
    }
}
