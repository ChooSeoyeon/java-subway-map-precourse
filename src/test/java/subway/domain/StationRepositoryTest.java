package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {
    StationRepository stationRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository();
    }

    @Test
    void 역_저장시_중복된_역_이름인_경우_예외가_발생한다() {
        Station station = new Station("강남역");
        stationRepository.addStation(station);

        assertThatThrownBy(() -> stationRepository.addStation(station))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 역 이름입니다.");
    }

    @Test
    void 역_이름으로_역이_존재하는지_화인할_수_있다() {
        Station station = new Station("강남역");
        stationRepository.addStation(station);

        assertThat(stationRepository.existsByName(station.getName())).isTrue();
    }
}
