package ru.devmark.service;

import org.springframework.stereotype.Service;
import ru.devmark.exception.ProfileNotFoundException;
import ru.devmark.model.Profile;

@Service
public class ProfileServiceMock implements ProfileService {

    @Override
    public Profile getProfile(int personId) {
        // имитируем обращение к БД
        if (personId == 123) {
            Profile profile = new Profile();
            profile.setId(personId);
            profile.setFirstName("Иван");
            profile.setLastName("Иванов");
            return profile;
        } else {
            throw new ProfileNotFoundException(personId);
        }
    }

    @Override
    public void createProfile(String firstName, String secondName, int age) {
        // ничего не делаем
    }

    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {
        // ничего не делаем
    }

    @Override
    public void deleteProfile(int id) {
        // ничего не делаем
    }
}
