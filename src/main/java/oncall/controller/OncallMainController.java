package oncall.controller;


import static oncall.view.input.InputView.requestStartDay;

import oncall.domain.DayOfMonth;

public class OncallMainController {

    private OncallMainController(){
    }

    public static void start() {
        getInputStartDay();
    }

    private static void getInputStartDay() {
        DayOfMonth dayOfMonth = requestStartDay();
    }

    private static void getInputWeeklyEmployee() {

    }
}
