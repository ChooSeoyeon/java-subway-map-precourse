package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Registration;
import subway.domain.Station;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }

    public void printMainFunction() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public void printStationFunction() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void printLineFunction() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void printRegistrationFunction() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public void printSuccessToAddStation() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public void printSuccessToDeleteStation() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void printAllStation(List<Station> stations) {
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }

    public void printSuccessToAddLine() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public void printSuccessToDeleteLine() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public void printAllLine(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
        System.out.println();
    }

    public void printSuccessToUpdateRegistration() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public void printSuccessToDeleteRegistration() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public void printAllRegistration(List<Registration> registrations) {
        System.out.println("## 지하철 노선도");
        for (Registration registration : registrations) {
            System.out.println("[INFO] " + registration.getLine().getName());
            System.out.println("[INFO] ---");
            for (Station station : registration.getStations()) {
                System.out.println("[INFO] " + station.getName());
            }
        }
    }
}
