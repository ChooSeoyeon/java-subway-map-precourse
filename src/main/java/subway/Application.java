package subway;

import java.util.Scanner;
import subway.controller.SubwayMapController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new SubwayMapController(new InputView(scanner), new OutputView()).run();
    }
}
