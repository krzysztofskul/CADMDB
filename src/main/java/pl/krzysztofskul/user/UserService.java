package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;
    private UserCategoryService userCategoryService;

    @Autowired
    public UserService(UserRepo userRepo, UserCategoryService userCategoryService) {
        this.userRepo = userRepo;
        this.userCategoryService = userCategoryService;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public List<User> loadAll() {
        return userRepo.findAll();
    }

    public User loadById(Long id) {
        return userRepo.findById(id).get();
    }

    public User loadByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public List<User> loadUserHospitalManagerList() {
        return userRepo.findAllByUserCategory(userCategoryService.loadByCode("HOSPITAL-MANAGER"));
    }

    public List<User> loadAllUnemployed() {
//        return userRepo.loadAllUnemployed();
//        return userRepo.loadAllUnemployedByNativeQuery();
        List<User> userList = userRepo.findAll();
        for (User user : userList) {
            Hibernate.initialize(user.getHospital());
        }
        userList.removeIf(user -> user.getHospital() != null);
        return userList;
    }

    public User loadByUserCategoryEnum(UserCategoryEnum userCategoryEnum) {
        switch (userCategoryEnum) {
            case HOSPITAL_MANAGER_GUEST: {
                return userRepo.findByUserCategory(userCategoryService.loadByCode("HOSPITAL MANAGER (GUEST)"));
            }
            default: {
                return userRepo.findByUserCategory(userCategoryService.loadByCode("ADMIN"));
            }
        }
    }
}