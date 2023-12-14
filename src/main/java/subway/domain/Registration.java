package subway.domain;

import java.util.List;

public class Registration {
    private Line line;
    private List<Station> stations;

    public Registration(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
        validateStations();
    }

    private void validateStations() {
        if (stations.size() < 2) {
            throw new IllegalArgumentException("노선에는 2개 이상의 역이 등록되어야 합니다.");
        }
    }
}
