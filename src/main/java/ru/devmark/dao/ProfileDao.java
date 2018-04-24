package ru.devmark.dao;

import ru.devmark.model.Profile;

import java.util.Optional;

public interface ProfileDao {

    Optional<Profile> getProfileById(int id);

    void insertProfile(String firstName, String secondName, int age);

    void updateProfile(String firstName, String secondName, int age, int id);

    void deleteProfileById(int id);
}
