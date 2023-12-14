package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LineRepositoryTest {
    @BeforeEach
    void setUp() {
        LineRepository.deleteAllLine();
    }

    @Test
    void 노선_목록을_조회할_수_있다() {
        Line line = new Line("2호선");
        LineRepository.addLine(line);

        List<Line> lines = LineRepository.findAllLine();

        assertThat(lines).contains(line);
    }

    @Test
    void 노선_저장시_중복된_노선_이름인_경우_예외가_발생한다() {
        Line line = new Line("2호선");
        LineRepository.addLine(line);

        assertThatThrownBy(() -> LineRepository.addLine(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 노선 이름입니다.");
    }

    @Test
    void 노선_이름으로_노선이_존재하는지_확인할_수_있다() {
        Line line = new Line("2호선");
        LineRepository.addLine(line);

        assertThat(LineRepository.existsLineByName(line.getName())).isTrue();
    }
}
