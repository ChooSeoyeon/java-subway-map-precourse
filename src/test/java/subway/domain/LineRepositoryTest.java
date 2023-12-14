package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
