package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RegistrationTest {
    @Test
    void 노선과_역목록으로_등록을_생성할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");

        Registration registration = new Registration(line, List.of(station1, station2));

        assertThat(registration.getLine()).isEqualTo(line);
        assertThat(registration.getStations()).containsExactly(station1, station2);
    }

    @Test
    void 등록_생성시_역이_2개_미만이면_예외가_발생한다() {
        Line line = new Line("2호선");
        Station station = new Station("강남역");

        assertThatThrownBy(() -> new Registration(line, List.of(station)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("노선에는 2개 이상의 역이 등록되어야 합니다.");
    }
}
