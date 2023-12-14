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

    public String readStationFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String inputFunction = scanner.nextLine();
        validateStationFunction(inputFunction);
        return inputFunction;
    }

    private void validateStationFunction(String inputFunction) {
        if (inputFunction.equals("1")) {
            return;
        }
        if (inputFunction.equals("2")) {
            return;
        }
        if (inputFunction.equals("3")) {
            return;
        }
        if (inputFunction.equals("B")) {
            return;
        }
        throw new IllegalArgumentException("지원하지 않는 기능입니다.\n");
    }

    public String readStationName() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readLineFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String inputFunction = scanner.nextLine();
        validateLineFunction(inputFunction);
        return inputFunction;
    }

    private void validateLineFunction(String inputFunction) {
        if (inputFunction.equals("1")) {
            return;
        }
        if (inputFunction.equals("2")) {
            return;
        }
        if (inputFunction.equals("3")) {
            return;
        }
        if (inputFunction.equals("B")) {
            return;
        }
        throw new IllegalArgumentException("지원하지 않는 기능입니다.\n");
    }

    public String readLineName() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readRegistrationFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String inputFunction = scanner.nextLine();
        validateRegistrationFunction(inputFunction);
        return inputFunction;
    }

    private void validateRegistrationFunction(String inputFunction) {
        if (inputFunction.equals("1")) {
            return;
        }
        if (inputFunction.equals("2")) {
            return;
        }
        if (inputFunction.equals("B")) {
            return;
        }
        throw new IllegalArgumentException("지원하지 않는 기능입니다.\n");
    }

    public int readOrder() {
        System.out.println("\n## 순서를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public String readStartStationName() {
        System.out.println("\n## 등록할 구간의 상행역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readEndStationName() {
        System.out.println("\n## 등록할 구간의 하행역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readDeleteLineName() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readDeleteStationName() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readDeleteRegistrationStationName() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine();
    }

    public String readDeleteRegistrationLineName() {
        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine();
    }
}
