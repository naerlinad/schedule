package model.comparators;

import model.notes.Note;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Note> {
    @Override
    public int compare(Note o1, Note o2) {
        return o2.getPriority() - o1.getPriority();
    }
}
