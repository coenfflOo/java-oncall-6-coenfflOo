package oncall.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import oncall.domain.LegalHoliday;

public class StartDateUtil {
    public static LocalDate calculateStartDate(int month, String startDay) {
        LocalDate date = LocalDate.of(Year.now().getValue(), month, 1);
        DayOfWeek day = DayOfWeek.valueOf(startDay.toUpperCase());
        while (date.getDayOfWeek() != day) {
            date = date.plusDays(1);
        }
        return date;
    }

    public static boolean isHolidayOrWeekend(LocalDate date) {
        return isWeekend(date) || isLegalHoliday(date);
    }

    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static boolean isLegalHoliday(LocalDate date) {
        return LegalHoliday.isHoliday(date.getMonthValue(), date.getDayOfMonth());
    }

}
