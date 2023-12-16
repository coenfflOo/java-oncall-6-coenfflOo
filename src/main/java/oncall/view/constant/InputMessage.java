package oncall.view.constant;

public enum InputMessage {
    REQUEST_START_DATE("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    REQUEST_WEEKLY_EMPLOYEE("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    REQUEST_HOLIDAY_EMPLOYEE("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),;
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
