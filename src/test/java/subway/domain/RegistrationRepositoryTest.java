package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationRepositoryTest {
    @BeforeEach
    void setUp() {
        RegistrationRepository.deleteAllRegistration();
    }

    @Test
    void 등록_목록을_조회할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("잠실역");
        Registration registration = new Registration(line, List.of(station1, station2));
        RegistrationRepository.addRegistration(registration);

        assertThat(RegistrationRepository.findAllRegistration()).containsExactly(registration);
    }
}
