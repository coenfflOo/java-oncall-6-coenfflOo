package oncall.view.input;

import static oncall.view.constant.InputMessage.*;

import java.util.List;
import oncall.domain.DayOfMonth;
import oncall.domain.Employee;
import oncall.domain.OnCallSchedule;
import oncall.util.InputUtil;
import oncall.util.Parser;

public class InputView {
    private InputView() {
    }

    public static DayOfMonth requestStartDay() {
        while (true) {
            try {
                System.out.print(REQUEST_START_DATE.getMessage());
                final String input = InputUtil.readLine();
                final List<String> dateInfo = Parser.parseList(input);
                String month = dateInfo.get(0);
                String startDay = dateInfo.get(1);
                return DayOfMonth.of(month, startDay);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static OnCallSchedule requestWeeklyEmployee() {
        while (true) {
            try {
                System.out.print(REQUEST_WEEKLY_EMPLOYEE.getMessage());
                final String input = InputUtil.readLine();
                final List<String> weeklyEmployee = Parser.parseList(input);
                return requestHolidayEmployee(Employee.of(weeklyEmployee));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }finally {
                System.out.println();
            }
        }
    }

    public static OnCallSchedule requestHolidayEmployee(Employee weeklyEmployee) {
        while (true) {
            try {
                System.out.print(REQUEST_HOLIDAY_EMPLOYEE.getMessage());
                final String input = InputUtil.readLine();
                final List<String> holidayEmployee = Parser.parseList(input);
                return OnCallSchedule.of(weeklyEmployee, Employee.of(holidayEmployee));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}