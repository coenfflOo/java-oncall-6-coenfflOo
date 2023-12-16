package oncall.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String DELIMITER = ";";
    private static final int POSITIVE_NUMBER_MINIMUM_RANGE = 1;
    // 10원부터 시작하며, 10원으로 나누어떨어지
    private static final Pattern REGEX_COIN_PATTERN = Pattern.compile("^(10|\\d{1,})0$");
    private static final Pattern REGEX_PRODUCT_PATTERN = Pattern.compile(
            "\\[([^,]+),(\\d+),(\\d+)]");
    // 100원부터 시작하며, 10원으로 나누어떨어지는 정규식
    private static final Pattern REGEX_PRICE_PATTERN = Pattern.compile("^(100|\\d{2,})(0)$");
    private static final Pattern REGEX_MENU_PATTERN = Pattern.compile("^.+$");
    //쉼표로 구분된 값
    private static final Pattern REGEX_COMMA_DELIMITER_PATTERN = Pattern.compile("^([^,]+,)+[^,]+$");
    //1000의 배수 검증
    private static final Pattern REGEX_THOUSANDS_DELIMITER_PATTERN = Pattern.compile("^(0|([1-9]\\d*000))$");

    // Default Constructor
    private Validate() {
    }


    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidPricePattern(String input) {
        return matchWithRegex(input, REGEX_PRICE_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
    }

    // 양수인가
    private static boolean isNotPositiveInteger(Integer value) {
        return value < POSITIVE_NUMBER_MINIMUM_RANGE;
    }

    //길이 제한 확인
    private static boolean isWithinLengthRange(String input, int min, int max) {
        return input.length() >= min && input.length() <= max;
    }

    //숫자만 포함되어 있는지 확인
    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    //
    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
