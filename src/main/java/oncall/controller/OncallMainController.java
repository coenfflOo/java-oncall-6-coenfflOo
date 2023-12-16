package oncall.controller;


import static oncall.util.StartDateUtil.calculateStartDate;
import static oncall.view.input.InputView.requestStartDay;
import static oncall.view.input.InputView.requestWeeklyEmployee;
import static oncall.service.SchedulerService.scheduleDuties;
import static oncall.view.output.OutputView.printResult;

import java.time.LocalDate;
import java.util.List;
import oncall.domain.DayOfMonth;
import oncall.domain.OnCallSchedule;
import oncall.service.SchedulerService;

public class OncallMainController {
    private static DayOfMonth dayOfMonth;
    private static OnCallSchedule onCallSchedule;
    private static SchedulerService schedulerService;

    private OncallMainController(){
    }

    public static void start() {
        getInputStartDay();
        getInputOnCallEmployee();
        schedulerService = new SchedulerService(onCallSchedule);
    }

    private static void getInputStartDay() {
        dayOfMonth = requestStartDay();
    }

    private static void getInputOnCallEmployee() {
        onCallSchedule = requestWeeklyEmployee();
    }

    private static void onCallResult() {
        LocalDate date = calculateStartDate(dayOfMonth.getMonth(), dayOfMonth.getStartDay());
        List<String> result =  schedulerService.scheduleDuties(date, dayOfMonth.getMonth(), dayOfMonth.getStartDay());
//        printResult(result, date);
    }
}
