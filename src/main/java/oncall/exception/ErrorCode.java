package oncall.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {
    INVALID_INPUT("잘못된 입력값입니다. 다시 입력해 주세요."),
    INVALID_MONTH("월은 숫자만 입력가능합니다. 다시 입력해 주세요."),
    INVALID_RANGE_OF_MONTH("월은 1~12 사이의 숫자만 입력 가능합니다. 다시 입력해 주세요."),
    INVALID_WEEK("요일은 월,화,수,목,금,토,일 중 하나를 입력해 주세요."),
    INVALID_NAME_LENGTH("이름은 1~5자 사이로 입력해 주세요."),
    INVALID_NAME_DUPLICATED("중복된 이름이 있습니다. 다시 입력해 주세요."),
    INVALID_PEOPLE_COUNT("인원은 5~35명 사이로 입력해 주세요."),
    INVALID_DIFFERENT_PEOPLE("평일 근무 인원과 동일한 직원을 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
