package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String inputFunction = scanner.nextLine();
        validateFunction(inputFunction);
        return inputFunction;
    }

    private void validateFunction(String inputFunction) {
        if (inputFunction.equals("1")) {
            return;
        }
        if (inputFunction.equals("2")) {
            return;
        }
        if (inputFunction.equals("3")) {
            return;
        }
        if (inputFunction.equals("4")) {
            return;
        }
        if (inputFunction.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("지원하지 않는 기능입니다.\n");
    }
}
