package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> findAllStation() {
        return Collections.unmodifiableList(stations);
    }

    public static void deleteAllStation() {
        stations.clear();
    }

    public static void addStation(Station station) {
        validateDuplicateStationName(station);
        stations.add(station);
    }

    private static void validateDuplicateStationName(Station station) {
        if (existsStationByName(station.getName())) {
            throw new IllegalArgumentException("이미 존재하는 역 이름입니다.");
        }
    }

    public static boolean existsStationByName(String name) {
        return stations.stream()
                .anyMatch(station -> station.isSameName(name));
    }

    public static void deleteStationByName(String name) {
        Station station = findStationByName(name);
        validateNonRelationshipWithRegistration(station);
        stations.remove(station);
    }

    public static Station findStationByName(String name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 역입니다."));
    }

    private static void validateNonRelationshipWithRegistration(Station station) {
        if (RegistrationRepository.existsRegistrationByStation(station)) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
