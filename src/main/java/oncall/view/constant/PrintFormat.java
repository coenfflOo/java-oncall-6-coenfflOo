package oncall.view.constant;

import java.text.DecimalFormat;

public enum PrintFormat {
    RESPONSE_EMPLOYEE("%d월 %d일 %s%s");

    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}