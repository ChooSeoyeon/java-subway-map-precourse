package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateDuplicateStationName(station);
        stations.add(station);
    }

    private static void validateDuplicateStationName(Station station) {
        if (existsByName(station.getName())) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    public static boolean existsByName(String name) {
        return stations.stream()
                .anyMatch(station -> station.isSameName(name));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
