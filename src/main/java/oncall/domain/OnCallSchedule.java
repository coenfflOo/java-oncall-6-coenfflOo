package oncall.domain;

import static oncall.exception.ErrorCode.INVALID_DIFFERENT_PEOPLE;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnCallSchedule {

    private static Employee weeklyEmployee;
    private static Employee holidayEmployee;

    public OnCallSchedule(Employee weeklyEmployee, Employee holidayEmployee) {
        this.weeklyEmployee = weeklyEmployee;
        this.holidayEmployee = holidayEmployee;
    }

    public static OnCallSchedule of(Employee weeklyEmployee, Employee holidayEmployee) {
        isSameEmployee(weeklyEmployee.getNames(), holidayEmployee.getNames());
        return new OnCallSchedule(weeklyEmployee, holidayEmployee);
    }

    private static void  isSameEmployee(List<String> weeklyEmployee, List<String> holidayEmployee) {
        INVALID_DIFFERENT_PEOPLE.validate(() -> !new HashSet<>(holidayEmployee).containsAll(weeklyEmployee));
    }

    public static List<String> getWeeklyEmployee() {
        return weeklyEmployee.getNames();
    }

    public static List<String> getHolidayEmployee() {
        return holidayEmployee.getNames();
    }
}
