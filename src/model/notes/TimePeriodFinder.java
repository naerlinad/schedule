package model.notes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimePeriodFinder {

    public String between(LocalDateTime beginning, LocalDateTime end) {

        long allMinutes = ChronoUnit.MINUTES.between(beginning, end);

        long minutes = allMinutes % 60;
        long hours = allMinutes / 60 % 24;
        long days = allMinutes / 60 / 24;

        StringBuilder sb = new StringBuilder();

        if (days > 0) {
            sb.append(days);
            sb.append(" day");
            if (days > 1) sb.append('s');
        }

        if (hours > 0) {
            if (!sb.isEmpty()) sb.append(", ");
            sb.append(hours);
            sb.append(" hour");
            if (hours > 1) sb.append('s');
        }

        if (minutes > 0) {
            if (!sb.isEmpty()) sb.append(", ");
            sb.append(minutes);
            sb.append(" minute");
            if (minutes > 1) sb.append('s');
        }

        return sb.toString();
    }
}
