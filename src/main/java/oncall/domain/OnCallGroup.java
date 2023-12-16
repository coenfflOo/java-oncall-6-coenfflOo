package oncall.domain;

public class OnCallGroup {
    private final Employee weeklyEmployee;
    private final Employee holidayEmployee;

    public OnCallGroup(Employee weeklyEmployee, Employee holidayEmployee) {
        this.weeklyEmployee = weeklyEmployee;
        this.holidayEmployee = holidayEmployee;
    }
}
