package oncall.view.output;

import static oncall.view.constant.PrintFormat.RESPONSE_EMPLOYEE;

import java.time.LocalDate;
import java.util.List;

public final class OutputView extends OutputWriter {
    private OutputView() {
    }

    public static void printResult(List<String> result, LocalDate date) {
        for (String name : result) {
            printFormat(RESPONSE_EMPLOYEE.getFormat(), date.getMonthValue(), date.getDayOfMonth(), name, System.lineSeparator());
            date = date.plusDays(1);
        }
    }
}