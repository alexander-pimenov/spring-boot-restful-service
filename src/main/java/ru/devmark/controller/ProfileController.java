package ru.devmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.model.Profile;
import ru.devmark.request.ProfileRequest;
import ru.devmark.service.ProfileService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        profileService.createProfile(
            request.getFirstName(),
            request.getLastName(),
            request.getAge()
        );
    }

    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(
            @Valid @RequestBody ProfileRequest request,
            @PathVariable int personId
    ) {
        profileService.updateProfile(
            request.getFirstName(),
            request.getLastName(),
            request.getAge(),
            personId
        );
    }

    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);
    }
}
