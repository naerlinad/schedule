package model.schedule;

import model.notes.Note;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schedule implements Serializable {
    private List<Note> notes;
    private int genId;
    private List<Note> currentList;

    public Schedule() {
        notes = new ArrayList<>();
        currentList = new ArrayList<>();
    }

    public boolean add(Note note) {
        note.setId(genId++);
        notes.add(note);
        return true;
    }

    public Note getById(int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    public boolean remove(int id) {
        Note note = getById(id);
        return remove(note);
    }

    public boolean remove(Note note) {
        notes.remove(note);
        currentList.remove(note);
        return true;
    }

    public String getByDate(LocalDate date) {
        currentList.clear();
        for (Note note : notes) {
            if (LocalDate.from(note.getDateTime()).equals(date)) {
                currentList.add(note);
            }
        }
        return iStringer(currentList);
    }

    private String iStringer(List<Note> list) {
        StringBuilder sb = new StringBuilder();
        for(Note note: list) {
            sb.append('\n');
            sb.append(note);
            sb.append('\n');
        }
        return sb.toString();
    }

    public String getByDateRange(LocalDate date1, LocalDate date2) {
        currentList.clear();
        for (Note note : notes) {
            LocalDate notesDate = LocalDate.from(note.getDateTime());
            if (!notesDate.isBefore(date1) && !notesDate.isAfter(date2)) {
                currentList.add(note);
            }
        }
        return iStringer(currentList);
    }

    public String getForToday() {
        return getByDate(LocalDate.now());
    }

    public String getForThisWeek() {
        LocalDate currentDate = LocalDate.now();
        return getForWeek(currentDate);
    }

    private String getForWeek(LocalDate currentDate) {
        int weekDay = currentDate.getDayOfWeek().getValue();
        long daysBack = (long) weekDay - 1;
        LocalDate startDate = currentDate.minusDays(daysBack);
        LocalDate endDate = startDate.plusDays(6);
        return getByDateRange(startDate, endDate);
    }

    public String getForNextWeek() {
        LocalDate date = LocalDate.now().plusDays(7);
        return getForWeek(date);
    }

    public String getForLastWeek() {
        LocalDate date = LocalDate.now().minusDays(7);
        return getForWeek(date);
    }

    public String getAllNotes() {
        currentList.clear();
        currentList = new ArrayList<>(notes);
        return iStringer(currentList);
    }

    public String getSorted(Comparator<Note> comparator) {
        currentList.sort(comparator);
        return iStringer(currentList);
    }
}
