package oncall.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DayOfMonthTest {

    @Test
    @DisplayName("1에서 12 사이의 숫자가 입력되면 해당 숫자를 반환한다.")
    void validateMonthCorrect() {
        DayOfMonth dayOfMonth = DayOfMonth.of("1", "월");
        assertEquals(1, dayOfMonth.getMonth());
    }

    @Test
    @DisplayName("1에서 12 외의 숫자가 입력되면 예외가 발생한다.")
    void validateMonthOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> DayOfMonth.of("13", "월"));
    }

    @Test
    @DisplayName("월에 해당하는 숫자가 아닌 문자가 입력되면 예외가 발생한다.")
    void validateMonthNotNumber() {
        assertThrows(IllegalArgumentException.class, () -> DayOfMonth.of("일", "월"));
    }

    @Test
    @DisplayName("월화수목금토일 중 하나가 입력되면 해당 문자를 반환한다.")
    void validateStartDayCorrect() {
        DayOfMonth dayOfMonth = DayOfMonth.of("1", "월");
        assertEquals("월", dayOfMonth.getStartDay());
    }

    @Test
    @DisplayName("월화수목금토일 외의 문자가 입력되면 예외가 발생한다.")
    void invalidateStartDay() {
        assertThrows(IllegalArgumentException.class, () -> DayOfMonth.of("1", "월요일"));
    }
}