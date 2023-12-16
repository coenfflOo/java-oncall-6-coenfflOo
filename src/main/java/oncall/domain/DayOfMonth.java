package oncall.domain;

import static oncall.exception.ErrorCode.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOfMonth {

    private static final Pattern REGEX_WEEK_PATTERN = Pattern.compile("^[월화수목금토일]$");
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private final int month;
    private final String startDay;

    private DayOfMonth(int month, String startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public static DayOfMonth of(String monthInput, String startDay) {
        int month = validate(monthInput, startDay);
        return new DayOfMonth(month, startDay);
    }

    public int getMonth() {
        return month;
    }

    public String getStartDay() {
        return startDay;
    }

    private static int validate(String monthInput, String startDay) {
        INVALID_INPUT.validate(() -> hasWhitespace(monthInput));
        INVALID_INPUT.validate(() -> hasWhitespace(startDay));
        INVALID_MONTH.validate(() -> !isNumeric(monthInput));
        INVALID_WEEK.validate(() -> isInvalidWeekPattern(startDay));
        int month = Integer.parseInt(monthInput);
        INVALID_RANGE_OF_MONTH.validate(() -> isRangeOfYears(month));
        return month;
    }

    //==validate Logic==//
    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isRangeOfYears(int input) {
        return input < MIN_MONTH || input > MAX_MONTH;
    }

    private static boolean isInvalidWeekPattern(String input) {
        return matchWithRegex(input, REGEX_WEEK_PATTERN);
    }

    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
