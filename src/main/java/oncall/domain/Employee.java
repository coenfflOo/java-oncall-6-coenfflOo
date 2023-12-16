package oncall.domain;

import static oncall.exception.ErrorCode.*;

import java.util.List;

public class Employee {
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
        return input.length() <= 5;
    }

    private static boolean isWithinLengthRange(List<String> input) {
        return input.size() >= 5 && input.size() <= 35;
    }

    private static boolean isDuplicated(List<String> input) {
        return input.stream().distinct().count() != input.size();
    }

}
