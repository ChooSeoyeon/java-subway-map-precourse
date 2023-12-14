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

    @Test
    void 역목록의_특정_위치에_역_추가시_위치가_범위밖이면_예외가_발생한다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Registration registration = new Registration(line, List.of(station1, station2));
        Station station3 = new Station("삼성역");

        assertThatThrownBy(() -> registration.registerStationToLine(4, station3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("추가할 수 없는 위치입니다.");
    }

    @Test
    void 역목록의_마지막_위치에_역을_추가할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Registration registration = new Registration(line, List.of(station1, station2));
        Station station3 = new Station("삼성역");

        registration.registerStationToLine(2, station3);

        assertThat(registration.getStations().get(2)).isEqualTo(station3);
    }

    @Test
    void 역목록의_처음_위치에_역을_추가할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Registration registration = new Registration(line, List.of(station1, station2));
        Station station3 = new Station("삼성역");

        registration.registerStationToLine(0, station3);

        assertThat(registration.getStations().get(0)).isEqualTo(station3);
    }

    @Test
    void 역목록의_중간_위치에_역을_추가할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Registration registration = new Registration(line, List.of(station1, station2));
        Station station3 = new Station("삼성역");

        registration.registerStationToLine(1, station3);

        assertThat(registration.getStations().get(1)).isEqualTo(station3);
    }

    @Test
    void 역목록에서_역_삭제시_현재_등록된_역이_2개_미만이면_예외가_발생한다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Registration registration = new Registration(line, List.of(station1, station2));

        assertThatThrownBy(() -> registration.removeStationFromLine(station1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개 이하의 역이 등록되어 있어 삭제할 수 없습니다.");
    }

    @Test
    void 역목록에_역_삭제시_현재_등록되지_않은_역이면_예외가_발생한다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Station station3 = new Station("삼성역");
        Registration registration = new Registration(line, List.of(station1, station2, station3));
        Station station4 = new Station("보라매역");

        assertThatThrownBy(() -> registration.removeStationFromLine(station4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("노선에 등록되지 않은 역입니다.");
    }

    @Test
    void 역목록에서_역을_삭제할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        Station station3 = new Station("삼성역");
        Registration registration = new Registration(line, List.of(station1, station2, station3));

        registration.removeStationFromLine(station2);

        assertThat(registration.getStations()).containsExactly(station1, station3);
    }
}
