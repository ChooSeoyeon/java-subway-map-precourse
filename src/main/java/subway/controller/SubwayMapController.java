package subway.controller;

import java.util.List;
import java.util.function.Supplier;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Registration;
import subway.domain.RegistrationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapController {
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayMapController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            outputView.printMainFunction();
            String function = repeatUntilSuccessWithReturn(inputView::readFunction);
            if (function.equals("Q")) {
                return;
            }
            if (function.equals("1")) {
                String subFunction = repeatUntilSuccessWithReturn(inputView::readStationFunction);
                if (subFunction.equals("1")) {
                    repeatUntilSuccess(this::addStation);
                    outputView.printSuccessToAddStation();
                    continue;
                }
                if (subFunction.equals("2")) {
                    repeatUntilSuccess(this::deleteStation);
                    outputView.printSuccessToDeleteStation();
                    continue;
                }
                if (subFunction.equals("3")) {
                    findAllStation();
                    continue;
                }
                if (subFunction.equals("B")) {
                    continue;
                }
            }
            if (function.equals("2")) {
                String subFunction = repeatUntilSuccessWithReturn(inputView::readLineFunction);
                if (subFunction.equals("1")) {
                    repeatUntilSuccess(this::addLine);
                    outputView.printSuccessToAddLine();
                    continue;
                }
                if (subFunction.equals("2")) {
                    repeatUntilSuccess(this::deleteLine);
                    outputView.printSuccessToDeleteLine();
                    continue;
                }
                if (subFunction.equals("3")) {
                    findAllLine();
                    continue;
                }
                if (subFunction.equals("B")) {
                    continue;
                }
            }
            if (function.equals("3")) {
                String subFunction = repeatUntilSuccessWithReturn(inputView::readRegistrationFunction);
                if (subFunction.equals("1")) {
                    repeatUntilSuccess(this::updateRegistration);
                    outputView.printSuccessToUpdateRegistration();
                    continue;
                }
                if (subFunction.equals("2")) {
                    repeatUntilSuccess(this::deleteRegistration);
                    outputView.printSuccessToDeleteRegistration();
                    continue;
                }
                if (subFunction.equals("B")) {
                    continue;
                }
            }
            if (function.equals("4")) {
                findAllRegistration();
            }
        }
    }

    private void findAllRegistration() {
        List<Registration> registrations = RegistrationRepository.findAllRegistration();
        outputView.printAllRegistration(registrations);
    }

    private void deleteRegistration() {
        String lineName = inputView.readDeleteRegistrationLineName();
        String stationName = inputView.readDeleteRegistrationStationName();
        Line line = new Line(lineName);
        Station station = new Station(stationName);
        Registration findRegistration = RegistrationRepository.findRegistrationByLine(line);
        findRegistration.removeStationFromLine(station);
        RegistrationRepository.updateRegistration(findRegistration);
    }

    private void updateRegistration() {
        String lineName = inputView.readLineName();
        String stationName = inputView.readStationName();
        int order = inputView.readOrder();
        Line line = new Line(lineName);
        Station station = new Station(stationName);
        Registration findRegistration = RegistrationRepository.findRegistrationByLine(line);
        findRegistration.registerStationToLine(order, station);
        RegistrationRepository.updateRegistration(findRegistration);
    }

    private void deleteLine() {
        String lineName = inputView.readDeleteLineName();
        LineRepository.deleteLineByName(lineName);
    }

    private void addLine() {
        String lineName = inputView.readLineName();
        Line line = new Line(lineName);
        String startStationName = inputView.readStartStationName();
        String endStationName = inputView.readEndStationName();
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        Registration registration = new Registration(line, List.of(startStation, endStation));
        LineRepository.addLine(line);
        RegistrationRepository.addRegistration(registration);
    }

    private void addStation() {
        String stationName = inputView.readStationName();
        Station station = new Station(stationName);
        StationRepository.addStation(station);
    }

    private void deleteStation() {
        String stationName = inputView.readDeleteStationName();
        StationRepository.deleteStationByName(stationName);
    }

    private void findAllStation() {
        List<Station> stations = StationRepository.findAllStation();
        outputView.printAllStation(stations);
    }

    private void findAllLine() {
        List<Line> lines = LineRepository.findAllLine();
        outputView.printAllLine(lines);
    }

    private <T> T repeatUntilSuccessWithReturn(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void repeatUntilSuccess(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
