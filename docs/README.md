# 🌹 최종 미션 - 개발자 비상근무

## **👀 [문제 확인하기](https://github.com/woowacourse-precourse/java-oncall-6)**

- 우아한테크코스 최종 미션 중 '개발자 비상근무'의 구현 기능과 구현 로직을 담은 문서입니다.
  - 비상근무의 달과 시작 요일을 입력받아 평일과 휴일을 고려하여 한 사람이 연속 두번의 비상근무를 하지 않도록 배정하는 프로그램입니다.
- 문제는 [여기](https://github.com/woowacourse-precourse/java-oncall-6)에서 확인하실 수 있습니다.

---

## 📝 **기능 목록 정리**

**✔️ 근무일 입력받기**

- [x]  `비상 근무를 배정할 월과 시작 요일을 입력하세요>` 출력하기
- [x]  콤마를 기준으로 입력받기
- [x]  월(숫자)과 시작 요일(일, 월, 화, 수, 목, 금, 토
- [x]  년도 고려x, 매년 2월은 28일까지만 있다고 가정
- [x]  입력 값이 올바르지 않은 경우, '비상 근무를 배정할 월과 시작 요일'부터 다시 입력

**✔️ 평일 비상 근무 이름 입력받기**

- [x]  `평일 비상 근무 순번대로 사원 닉네임을 입력하세요>`출력하기
- [x]  중복된 이름 불가
- [x]  최대 5자
- [x]  5명 이상, 35명 이하 입력
- [x]  입력 값이 올바르지 않은 경우, '평일 순번'부터 다시 입력

**✔️ 휴일 비상 근무 이름 입력받기**

- [x]  `휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>` 출력하기
- [x]  중복된 이름 불가
- [x]  최대 5자
- [x]  5명 이상, 35명 이하 입력
- [x]  평일 비상 근무 인원의 이름들과 동일한가
- [x]  입력 값이 올바르지 않은 경우, '평일 순번'부터 다시 입력

**✔️ 근무일 배정하기**

- [x]  순번에 따라 비상 근무일 배정
- [x]  비상 근무자는 평일 순번, 휴일 순번 각각 1회 편성
- [x]  연속 2일 근무 불가 → 다음 근무자와 순서 바꾸기
- [x]  휴일은 토요일, 일요일, 1월 1일, 3월 1일, 5월 5일, 6월 6일, 8월 15일, 10월 3일, 10월 9일, 12월 25일

**✔️ 비상 근무 출력**

- [x]  평일이면서 법정공휴일의 경우에만 요일 뒤에 (휴일) 표기
- [x]  출력을 완료하면 프로그램은 종료