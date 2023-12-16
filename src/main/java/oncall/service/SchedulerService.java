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

    public static List<String> scheduleDuties(LocalDate date, int month, String startDay) {
        List<String> schedule = new ArrayList<>();
        int weekdayIndex = 0, holidayIndex = 0;
        String lastAssignedEmployee = "";

        while (date.getMonthValue() == month) {
            boolean isHoliday = isHolidayOrWeekend(date);
            String employeeName="";

            if (isHoliday) {
                employeeName = getNextEmployee(holidayNames, holidayIndex++, lastAssignedEmployee);
                schedule.add( "(휴일) " + employeeName);
            }
            if (!isHoliday){
                employeeName = getNextEmployee(weekdayNames, weekdayIndex++, lastAssignedEmployee);
                schedule.add(" " + employeeName);
            }
            lastAssignedEmployee = employeeName;
            date = date.plusDays(1);
        }

        return schedule;
    }

    private static String getNextEmployee(List<String> names, int index, String lastEmployee) {
        String employee = names.get(index % names.size());
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

