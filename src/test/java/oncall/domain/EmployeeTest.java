package oncall.domain;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    @DisplayName("중복되는 이름을 가진 Employee 객체 생성 시 예외 발생")
    void createEmployeeWithDuplicateName_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Employee.of(Collections.singletonList("홍길동,홍길동,김길동,고길동,장길동")));
    }

    @Test
    @DisplayName("이름의 길이가 5자를 초과한  Employee 객체 생성 시 예외 발생")
    void createEmployeeWithLongName_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Employee.of(Collections.singletonList("홍길동,홍길동일까아닐까,김길동,고길동,장길동,이길동")));
    }

    @Test
    @DisplayName("5명 이하 입력받아 Employee 객체 생성 시 예외 발생")
    void createEmployeeWithLessAmount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Employee.of(Collections.singletonList("홍길동,장길동,이길동")));
    }

    @Test
    @DisplayName("35명 이상 입력받아 Employee 객체 생성 시 예외 발생")
    void createEmployeeWithMoreAmount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Employee.of(Collections.singletonList("홍길동,장길동,이길동,김길동,고길동,박길동,윤길동,최길동,백길동,배길동,베길동,비길동,가,나,다,라,마,바,사,아,자,차,카,타,파,하,아,야,어,여,오,요우,유,으,이,앍,엙,올,울,하,언,제,까,지,해,야,하,지")));
    }
}