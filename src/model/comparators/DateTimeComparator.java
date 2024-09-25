package model.comparators;

import model.notes.Note;

import java.util.Comparator;

public class DateTimeComparator implements Comparator<Note> {

    @Override
    public int compare(Note o1, Note o2) {
        return o1.getDateTime().compareTo(o2.getDateTime());
    }

}
