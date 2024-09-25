package model.notes;

import java.time.LocalDateTime;

public class Task extends Note {
    private TaskStatus status;

    public Task(String title, LocalDateTime deadline) {
        super(title, deadline);
        status = TaskStatus.Unaccomplished;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void switchStatus() {
        if(status == TaskStatus.Unaccomplished) {
            status = TaskStatus.Accomplished;
        } else {
            status = TaskStatus.Unaccomplished;
        }
    }

    public String getRemainingTime() {
        LocalDateTime deadline = getDateTime();
        LocalDateTime thisMoment = LocalDateTime.now();
        if (thisMoment.isAfter(deadline)) {
            return "no time left";
        }
        TimePeriodFinder tp = new TimePeriodFinder();
        return tp.between(thisMoment, deadline);
    }

    @Override
    public String getInfo() {
        return String.format("Id: %d\nTask: %s\nStatus: %s\nDeadline: %s\nRemaining time: %s\nPriority: %s",
                getId(), getTitle(), getStatus(), getDateTime().toString().replace('T',' '),
                getRemainingTime(), getPriorityInfo());
    }
}
