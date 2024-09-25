package model.notes;

public class Priority {
    public static final int DEFAULT = 0;
    public static final int HIGH = 1;
    public static final int DRAMATIC = 2;

    public static String getDescription (int value) {
        if (value == 0) return "Default";
        if (value == 1) return "High";
        if (value == 2) return "Dramatic";
        return "";
    }
}
