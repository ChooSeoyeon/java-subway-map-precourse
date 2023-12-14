package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> findAllLine() {
        return Collections.unmodifiableList(lines);
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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAllLine() {
        lines.clear();
    }
}
