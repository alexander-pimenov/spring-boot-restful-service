package ru.devmark.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.devmark.model.Country;

import java.util.List;
import java.util.Map;

@Repository
public class GeoDao {

    private static final String SQL_GET_ALL_COUNTRIES = "select * from country order by name";

    private static final String SQL_GET_ALL_CITIES =
        "select c.name as city_name, n.name as country_name from city c" +
        " left join country n on c.country_id = n.id order by n.name";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CityExtractor cityExtractor;

    public List<Country> getAllCountries() {
        return jdbcTemplate.query(SQL_GET_ALL_COUNTRIES, countryMapper);
    }

    public Map<String, List<String>> getGroupedCities() {
        return jdbcTemplate.query(SQL_GET_ALL_CITIES, cityExtractor);
    }
}
