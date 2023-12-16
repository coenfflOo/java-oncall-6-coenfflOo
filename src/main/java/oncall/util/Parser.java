package oncall.util;

import static oncall.exception.ErrorCode.INVALID_INPUT;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern COMMA_PATTERN = Pattern.compile("^\\d+,[가-힣]+$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L}]+(,[\\p{L}]+)*$");

    //==Business Logic==//
    public static List<String> parseList(String str) {
        INVALID_INPUT.validate(() -> hasWhitespace(str));
        INVALID_INPUT.validate(() -> isInvalidDatePattern(str));
        return Arrays.asList(str.trim().split(",\\s*"));
    }

    public static List<String> parseNameList(String str) {
        INVALID_INPUT.validate(() -> hasWhitespace(str));
        INVALID_INPUT.validate(() -> isInvalidNamePattern(str));
        return Arrays.asList(str.trim().split(",\\s*"));
    }

    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidDatePattern(String input) {
        return matchWithRegex(input, COMMA_PATTERN);
    }

    private static boolean isInvalidNamePattern(String input) {
        return matchWithRegex(input, NAME_PATTERN);
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
