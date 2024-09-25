package model.notes;

import java.time.LocalDateTime;

public class Event extends Note {
    private LocalDateTime endTime;

    public Event(String title, LocalDateTime startTime, LocalDateTime endTime) {
        super(title, startTime);
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        if (endTime == null) return "unknown";
        TimePeriodFinder tp = new TimePeriodFinder();
        return tp.between(getDateTime(), endTime);
    }

    @Override
    public String getInfo() {
        String str = String.format("Id: %d\nEvent: %s\nBegins: %s",
                getId(), getTitle(), getDateTime().toString().replace('T', ' '));

        if (endTime == null) str += "\nDuration: unknown";

        else str += String.format("\nEnds: %s\nDuration: %s",
                    getEndTime().toString().replace('T', ' '), getDuration());

        str += "\nPriority: " + getPriorityInfo();

        return str;
    }
}
