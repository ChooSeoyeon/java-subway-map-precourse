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
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
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
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readLineFunction() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");

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
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String readRegistrationFunction() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
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
}
