package developer.remarks.service;

import developer.remarks.dao.ProfileDao;
import developer.remarks.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {

    private final ProfileDao profileDao;

    @Autowired
    public ProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public Profile getProfile(int personId) {
        return profileDao.getProfileById(personId);
    }
}
