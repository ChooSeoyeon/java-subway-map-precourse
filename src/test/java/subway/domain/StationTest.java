package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StationTest {
    @Test
    void 이름으로_역을_생성할_수_있다() {
        Station station = new Station("강남역");
        assertThat(station.getName()).isEqualTo("강남역");
    }

    @Test
    void 역_생성시_이름이_두글자_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Station("역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("역 이름은 2글자 이상이어야 합니다.");
    }
}
