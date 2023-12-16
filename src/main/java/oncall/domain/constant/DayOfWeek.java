package oncall.domain.constant;

public enum DayOfWeek {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String dayKor;

    DayOfWeek(String dayKor) {
        this.dayKor = dayKor;
    }

    public static String getEnglishName(String dayKor) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.dayKor.equals(dayKor)) {
                return day.name().toLowerCase();
            }
        }
        return null; // 혹은 예외 처리
    }

    public static String getDayKor(java.time.DayOfWeek day) {
        DayOfWeek[] days = DayOfWeek.values();
        int dayIndex = day.ordinal();
        if (dayIndex >= 0 && dayIndex < days.length) {
            return days[dayIndex].dayKor;
        }
        return null;
    }
}
