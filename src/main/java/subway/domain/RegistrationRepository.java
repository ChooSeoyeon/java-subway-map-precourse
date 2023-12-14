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
        registrations.add(registration);
    }

    public static boolean existsRegistrationByStation(Station station) {
        return false; // TODO
    }
}
