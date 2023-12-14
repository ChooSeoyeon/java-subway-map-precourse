package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.length() < 2) {
            throw new IllegalArgumentException("노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
