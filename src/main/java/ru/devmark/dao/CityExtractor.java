package ru.devmark.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class CityExtractor implements ResultSetExtractor<Map<String, List<String>>> {

    @Override
    public Map<String, List<String>> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        Map<String, List<String>> data = new LinkedHashMap<>();
        while (rs.next()) {
            String country = rs.getString("country_name");
            data.putIfAbsent(country, new ArrayList<>());
            String city = rs.getString("city_name");
            data.get(country).add(city);
        }
        return data;
    }
}
