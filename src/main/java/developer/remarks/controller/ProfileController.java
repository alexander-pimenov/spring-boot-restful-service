package developer.remarks.controller;

import developer.remarks.model.Profile;
import developer.remarks.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/{personId:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Profile getProfile(@PathVariable String personId) {
        return profileService.getProfile(Integer.valueOf(personId));
    }
}
