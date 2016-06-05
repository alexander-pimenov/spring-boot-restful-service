package developer.remarks.service;

import developer.remarks.exception.ProfileNotFoundException;
import developer.remarks.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {

    public Profile getProfile(int personId) {
        // имитируем обращение к БД
        if (personId == 2) {
            return new Profile(personId, "Иван", "Петров");
        } else {
            throw new ProfileNotFoundException(personId);
        }
    }
}
