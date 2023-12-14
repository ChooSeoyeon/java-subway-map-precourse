package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    void 이름으로_노선을_생성할_수_있다() {
        Line line = new Line("2호선");
        assertThat(line.getName()).isEqualTo("2호선");
    }

    @Test
    void 노선_생성시_이름이_두글자_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Line("호"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("노선 이름은 2글자 이상이어야 합니다.");
    }
}
