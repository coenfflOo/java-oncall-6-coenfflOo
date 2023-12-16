package oncall.view.output;

import oncall.view.constant.OutputMessage;

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

    public static void printFormat(String format, Object object,Object object2,Object object3,Object object4) {
        System.out.printf(format,object,object2,object3,object4);
    }
}