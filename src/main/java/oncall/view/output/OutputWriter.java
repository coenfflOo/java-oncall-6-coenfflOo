package oncall.view.output;

import lotto.view.constant.OutputMessage;

sealed class OutputWriter
        permits OutputView {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printFormat(String format, Object object){
        System.out.printf(format,object);
    }

    public static void printMessageResponse(OutputMessage responseMessage) {
        println(responseMessage.getMessage());
    }
}