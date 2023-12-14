package subway.enums;

public enum MainFunction {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    PRINT_SUBWAY_MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String number;
    private final String description;

    MainFunction(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return number + ". " + description;
    }
}

