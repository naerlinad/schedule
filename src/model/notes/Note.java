package model.notes;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Note implements Serializable {
    private int id;
    private String title;
    private LocalDateTime dateTime;
    private int priority;

    public Note(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setDefaultPriority() {
        this.priority = Priority.DEFAULT;
    }

    public void setHighPriority() {
        this.priority = Priority.HIGH;
    }

    public void setDramaticPriority() {
        this.priority = Priority.DRAMATIC;
    }

    public String getPriorityInfo() {
        return Priority.getDescription(priority);
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo();
    }
}
