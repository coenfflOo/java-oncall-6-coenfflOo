package oncall.util;

import static oncall.exception.ErrorCode.INVALID_INPUT;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern COMMA_PATTERN = Pattern.compile(",\\s*");
    public static int parseInt(String str) {
        return Integer.parseInt(str.trim());
    }

    public static Map<String, String> parseMap(String str) {
        Map<String, String> map = new HashMap<>();
        String[] pairs = str.split(",\\s*");
        for (String pair : pairs) {
            String[] keyValue = pair.split("-");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

    public static List<Integer> parseIntegerList(String str) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = str.split(",\\s*");
        for (String number : numbers) {
            list.add(Integer.parseInt(number.trim()));
        }
        return list;
    }
    public static List<String> parseList(String str) {
        INVALID_INPUT.validate(() -> hasWhitespace(str));
        INVALID_INPUT.validate(() -> isInvalidDatePattern(str));
        return Arrays.asList(str.trim().split(",\\s*"));
    }

    //==Business Logic==//
    public static List<String> parseDayList(String str) {
        INVALID_INPUT.validate(() -> hasWhitespace(str));
        INVALID_INPUT.validate(() -> isInvalidDatePattern(str));
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

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
