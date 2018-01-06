package ru.devmark.dao;

import ru.devmark.model.Profile;

import java.util.Optional;

public interface ProfileDao {

    Optional<Profile> getProfileById(int id);
}
