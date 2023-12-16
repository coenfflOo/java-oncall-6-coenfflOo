package oncall.service;

import static oncall.util.StartDateUtil.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import oncall.domain.OnCallSchedule;

public class SchedulerService {

    private static List<String> weekdayNames;
    private static List<String> holidayNames;


    public SchedulerService(OnCallSchedule onCallSchedule) {
        this.weekdayNames = new ArrayList<>(onCallSchedule.getWeeklyEmployee());
        this.holidayNames = new ArrayList<>(onCallSchedule.getHolidayEmployee());
    }

    public static List<String> scheduleDuties(LocalDate date, int month) {
        List<String> schedule = new ArrayList<>();
        int weekdayIndex = 0, holidayIndex = 0;
        String lastAssignedEmployee = "";
        while (date.getMonthValue() == month) {
            boolean isHoliday = isHolidayOrWeekend(date);
            if (isHoliday) {
                lastAssignedEmployee = assignHolidayEmployee(date, holidayIndex++, lastAssignedEmployee, schedule);
            }
            if (!isHoliday) {
                lastAssignedEmployee = assignWeekdayEmployee(weekdayIndex++, lastAssignedEmployee, schedule);
            }
            date = date.plusDays(1);
        }
        return schedule;
    }

    private static String assignHolidayEmployee(LocalDate date, int holidayIndex, String lastAssignedEmployee,
                                                List<String> schedule) {
        String employeeName = getNextEmployee(holidayNames, holidayIndex, lastAssignedEmployee);
        if (isLegalHoliday(date)) {
            schedule.add("(휴일) " + employeeName);
        }
        if (isWeekend(date)) {
            schedule.add(" " + employeeName);
        }
        return employeeName;
    }

    private static String assignWeekdayEmployee(int weekdayIndex, String lastAssignedEmployee, List<String> schedule) {
        String employeeName = getNextEmployee(weekdayNames, weekdayIndex, lastAssignedEmployee);
        schedule.add(" " + employeeName);
        return employeeName;
    }

    private static String getNextEmployee(List<String> names, int index, String lastEmployee) {
        index %= names.size();
        String employee = names.get(index);
        if (employee.equals(lastEmployee)) {
            swapEmployeeNames(names, index);
            employee = names.get(index % names.size());
        }
        return employee;
    }


    private static void swapEmployeeNames(List<String> names, int index) {
        int nextIndex = (index + 1) % names.size();
        String temp = names.get(index);
        names.set(index, names.get(nextIndex));
        names.set(nextIndex, temp);
    }
}

