package ru.devmark.dao;

import ru.devmark.exception.ProfileNotFoundException;
import ru.devmark.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    private static final String SQL_GET_PROFILE_BY_ID =
            "select id, first_name, last_name from profiles where id = :id";

    private final ProfileMapper profileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileDaoImpl(
            ProfileMapper profileMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.profileMapper = profileMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Profile getProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        List<Profile> profiles = jdbcTemplate.query(
                SQL_GET_PROFILE_BY_ID,
                params,
                profileMapper
        );
        if (profiles.isEmpty()) {
            throw new ProfileNotFoundException(id);
        }
        return profiles.get(0);
    }
}
