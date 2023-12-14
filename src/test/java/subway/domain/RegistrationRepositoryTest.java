package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 등록_저장시_중복된_노선인_경우_예외가_발생한다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("잠실역");
        Registration registration = new Registration(line, List.of(station1, station2));
        RegistrationRepository.addRegistration(registration);

        assertThatThrownBy(() -> RegistrationRepository.addRegistration(registration))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 등록된 노선입니다.");
    }

    @Test
    void 노선_이름으로_노선이_존재하는지_화인할_수_있다() {
        Line line = new Line("2호선");
        Station station1 = new Station("강남역");
        Station station2 = new Station("잠실역");
        Registration registration = new Registration(line, List.of(station1, station2));
        RegistrationRepository.addRegistration(registration);

        assertThat(RegistrationRepository.existsRegistrationByLine(line)).isTrue();
    }
}
