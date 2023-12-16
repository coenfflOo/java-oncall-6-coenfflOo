package oncall;

import camp.nextstep.edu.missionutils.Console;
import oncall.controller.OncallMainController;

public class Application {
    public static void main(String[] args) {
        OncallMainController.start();
        Console.close();
    }
}
