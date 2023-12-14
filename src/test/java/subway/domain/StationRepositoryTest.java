package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StationRepositoryTest {
    @BeforeEach
    void setUp() {
        StationRepository.deleteAllStation();
    }

    @Test
    void 역_저장시_중복된_역_이름인_경우_예외가_발생한다() {
        Station station = new Station("강남역");
        StationRepository.addStation(station);

        assertThatThrownBy(() -> StationRepository.addStation(station))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 역 이름입니다.");
    }

    @Test
    void 역_이름으로_역이_존재하는지_화인할_수_있다() {
        Station station = new Station("강남역");
        StationRepository.addStation(station);

        assertThat(StationRepository.existsStationByName(station.getName())).isTrue();
    }

    //- [x] 역 이름으로 역을 삭제한다 (역 목록에서 역을 제거)
    //    - [x] 존재하지 않는 역인 경우 예외를 발생시킨다
    //    - [x] 노선에 등록된 역인 경우 예외를 발생시킨다

    @Test
    void 역_이름으로_역을_삭제할_수_있다() {
        Station station = new Station("강남역");
        StationRepository.addStation(station);
        StationRepository.deleteStationByName(station.getName());

        assertThat(StationRepository.existsStationByName(station.getName())).isFalse();
    }

    @Test
    void 역_삭제시_존재하지_않는_역이면_예외가_발생한다() {
        Station station = new Station("강남역");
        StationRepository.addStation(station);

        assertThatThrownBy(() -> StationRepository.deleteStationByName("잠실역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 역입니다.");
    }

    @Disabled
    @Test
    void 역_삭제시_노선에_등록된_역이면_예외가_발생한다() {
        Station station1 = new Station("강남역");
        Station station2 = new Station("잠실역");
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        Registration registration = new Registration(new Line("2호선"), List.of(station1, station2));
        // RegistrationRepository.addRegistration(registration);

        assertThatThrownBy(() -> StationRepository.deleteStationByName(station1.getName()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("노선에 등록된 역은 삭제할 수 없습니다.");
    }
}
