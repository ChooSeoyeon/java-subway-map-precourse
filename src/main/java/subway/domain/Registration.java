package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private Line line;
    private ArrayList<Station> stations;

    public Registration(Line line, List<Station> stations) {
        this.line = line;
        this.stations = new ArrayList<>(stations);
        validateStations();
    }

    private void validateStations() {
        validateStationCount();
    }

    private void validateStationCount() {
        if (stations.size() < 2) {
            throw new IllegalArgumentException("노선에는 2개 이상의 역이 등록되어야 합니다.");
        }
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void registerStationToLine(int index, Station station) {
        validateRegisterStationToLine(index, station);
        stations.add(index, station);
    }

    private void validateRegisterStationToLine(int index, Station station) {
        validateOutOfRangeIndex(index);
        validateDuplicateStation(station);
    }

    private void validateOutOfRangeIndex(int index) {
        if (index < 0 || index > stations.size()) {
            throw new IllegalArgumentException("추가할 수 없는 위치입니다.");
        }
    }

    private void validateDuplicateStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 등록된 역입니다.");
        }
    }

    public void removeStationFromLine(Station station) {
        validateRemoveStationFromLine(station);
        stations.remove(station);
    }

    private void validateRemoveStationFromLine(Station station) {
        validateExistStationCount();
        validateExistStation(station);
    }

    private void validateExistStationCount() {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException("2개 이하의 역이 등록되어 있어 삭제할 수 없습니다.");
        }
    }

    private void validateExistStation(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("노선에 등록되지 않은 역입니다.");
        }
    }
}
