package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.length() < 2) {
            throw new IllegalArgumentException("역 이름은 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
