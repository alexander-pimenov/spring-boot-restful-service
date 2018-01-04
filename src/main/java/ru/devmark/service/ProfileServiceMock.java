package ru.devmark.service;

import org.springframework.stereotype.Service;
import ru.devmark.model.Profile;

@Service
public class ProfileServiceMock implements ProfileService {

    @Override
    public Profile getProfile(int personId) {
        Profile profile = new Profile();
        profile.setId(123);
        profile.setFirstName("Иван");
        profile.setLastName("Иванов");
        return profile;
    }
}
