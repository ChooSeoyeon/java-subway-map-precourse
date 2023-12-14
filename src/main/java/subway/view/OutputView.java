package subway.view;

import java.util.List;
import subway.domain.Line;
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
}
