package oncall.domain.constant;

public enum LegalHoliday {
    NEW_YEAR(1, 1),
    INDEPENDENCE_MOVEMENT_DAY(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25);

    private final int month;

    private final int day;

    LegalHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        for (LegalHoliday holiday : LegalHoliday.values()) {
            if (holiday.month == month && holiday.day == day) {
                return true;
            }
        }
        return false;
    }
}
