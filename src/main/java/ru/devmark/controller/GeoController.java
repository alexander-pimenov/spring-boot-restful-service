package ru.devmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.dao.GeoDao;
import ru.devmark.model.Country;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/geo", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeoController {

    @Autowired
    private GeoDao geoDao;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return geoDao.getAllCountries();
    }

    @GetMapping("/cities")
    public Map<String, List<String>> getGroupedCities() {
        return geoDao.getGroupedCities();
    }
}
