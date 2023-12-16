package oncall.view.input;

import static oncall.view.constant.InputMessage.*;

import java.util.List;
import oncall.domain.DayOfMonth;
import oncall.domain.Employee;
import oncall.domain.OnCallGroup;
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

    public static OnCallGroup requestWeeklyEmployee() {
        while (true) {
            try {
                System.out.print(REQUEST_WEEKLY_EMPLOYEE.getMessage());
                final String input = InputUtil.readLine();
                final List<String> weeklyEmployee = Parser.parseList(input);
                return requestHolidayEmployee(Employee.of(weeklyEmployee));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static OnCallGroup requestHolidayEmployee(Employee weeklyEmployee) {
        while (true) {
            try {
                System.out.print(REQUEST_HOLIDAY_EMPLOYEE.getMessage());
//                final String input = InputUtil.readLine();
//                final List<Integer> number = Parser.parseInput(input);
//                return BallNumber.of(number);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}