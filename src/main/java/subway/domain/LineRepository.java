package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> findAllLine() {
        return Collections.unmodifiableList(lines);
    }

    public static void addInitLine() {
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));
    }

    public static void addLine(Line line) {
        validateDuplicateLineName(line);
        lines.add(line);
    }

    private static void validateDuplicateLineName(Line line) {
        if (existsLineByName(line.getName())) {
            throw new IllegalArgumentException("이미 존재하는 노선 이름입니다.");
        }
    }

    public static boolean existsLineByName(String name) {
        return lines.stream()
                .anyMatch(line -> line.isSameName(name));
    }

    public static void deleteLineByName(String name) {
        Line line = findLineByName(name);
        lines.remove(line);
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노선입니다."));
    }

    public static void deleteAllLine() {
        lines.clear();
    }
}
