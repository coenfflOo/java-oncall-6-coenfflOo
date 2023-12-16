package oncall.view.output;

import static oncall.domain.constant.DayOfWeek.getDayKor;
import static oncall.view.constant.PrintFormat.RESPONSE_EMPLOYEE;

import java.time.LocalDate;
import java.util.List;

public final class OutputView extends OutputWriter {
    private OutputView() {
    }

    public static void printResult(List<String> result, LocalDate date) {
        for (String name : result) {
            String day = getDayKor(date.getDayOfWeek());
            printFormat(RESPONSE_EMPLOYEE.getFormat(), date.getMonthValue(), date.getDayOfMonth(), day, name);
            date = date.plusDays(1);
            printNewLine();
        }
    }
}