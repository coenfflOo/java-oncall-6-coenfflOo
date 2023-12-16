package oncall.domain;

import static oncall.exception.ErrorCode.*;

import java.util.List;

public class Employee {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_PEOPLE_LENGTH = 5;
    private static final int MAX_PEOPLE_LENGTH = 35;

    private final List<String> names;

    private Employee(List<String> names) {
        this.names = names;
    }

    public static Employee of(List<String> names) {
        validate(names);
        return new Employee(names);
    }

    private static void validate(List<String> name) {
        INVALID_PEOPLE_COUNT.validate(() -> !isWithinLengthRange(name));
        INVALID_NAME_DUPLICATED.validate(() -> isDuplicated(name));
        for (String input : name) {
            INVALID_INPUT.validate(() -> hasWhitespace(input));
            INVALID_NAME_LENGTH.validate(() -> !isWithinLengthRange(input));
        }
    }

    //==validate Logic==
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isWithinLengthRange(String input) {
        return input.length() <= MAX_NAME_LENGTH;
    }

    private static boolean isWithinLengthRange(List<String> input) {
        return input.size() >= MIN_PEOPLE_LENGTH && input.size() <= MAX_PEOPLE_LENGTH;
    }

    private static boolean isDuplicated(List<String> input) {
        return input.stream().distinct().count() != input.size();
    }

    public List<String> getNames() {
        return names;
    }
}
