package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrationRepository {
    private static final List<Registration> registrations = new ArrayList<>();

    public static List<Registration> findAllRegistration() {
        return Collections.unmodifiableList(registrations);
    }

    public static void deleteAllRegistration() {
        registrations.clear();
    }

    public static void addRegistration(Registration registration) {
        validateDuplicateRegistration(registration);
        registrations.add(registration);
    }

    private static void validateDuplicateRegistration(Registration registration) {
        if (existsRegistrationByLine(registration.getLine())) {
            throw new IllegalArgumentException("이미 등록된 노선입니다.");
        }
    }

    public static boolean existsRegistrationByLine(Line line) {
        return registrations.stream()
                .anyMatch(registration -> registration.isSameLine(line));
    }

    public static boolean existsRegistrationByStation(Station station) {
        return registrations.stream()
                .anyMatch(registration -> registration.hasStation(station));
    }

    public static void deleteRegistrationByLine(Line line) {
        Registration registration = findRegistrationByLine(line);
        registrations.remove(registration);
    }

    public static Registration findRegistrationByLine(Line line) {
        return registrations.stream()
                .filter(registration -> registration.isSameLine(line))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등록 정보입니다."));
    }

    public static void updateRegistration(Registration registration) {
        RegistrationRepository.deleteRegistrationByLine(registration.getLine());
        RegistrationRepository.addRegistration(registration);
    }
}
