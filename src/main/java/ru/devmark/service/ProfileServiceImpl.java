package ru.devmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.devmark.dao.ProfileDao;
import ru.devmark.exception.ProfileNotFoundException;
import ru.devmark.model.Profile;

@Primary
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Profile getProfile(int personId) {
        return profileDao.getProfileById(personId)
                .orElseThrow(() -> new ProfileNotFoundException(personId));
    }

    @Override
    public void createProfile(String firstName, String secondName, int age) {
        profileDao.insertProfile(firstName, secondName, age);
    }

    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {
        Profile profile = profileDao.getProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
        profileDao.updateProfile(firstName, secondName, age, profile.getId());
    }

    @Override
    public void deleteProfile(int id) {
        Profile profile = profileDao.getProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
        profileDao.deleteProfileById(profile.getId());
    }
}
