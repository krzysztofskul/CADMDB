package pl.krzysztofskul.user;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalRepo;
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;
    private UserCategoryService userCategoryService;

    @Autowired
    public UserService(
            UserRepo userRepo,
            UserCategoryService userCategoryService
    ) {
        this.userRepo = userRepo;
        this.userCategoryService = userCategoryService;
    }

    /** CRUD create */

    public void save(User user) {
        userRepo.save(user);
    }

    /** CRUD read */

    public List<User> loadAll() {
        return userRepo.findAll();
    }

    public User loadById(Long id) {
        return userRepo.findById(id).get();
    }

    public User loadByIdWithHospitalsManagingList(Long userId) {
        User user = loadById(userId);
        Hibernate.initialize(user.getHospitalManagingList());
        Hibernate.initialize(user.getDepartmentManagingList());
        Hibernate.initialize(user.getRoomManagingList());
        return user;
    }

    public User loadByEmail(String email) {
        return userRepo.findByEmail(email);
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

    /** CRUD update */

    /** CRUD delete */

    public void delete(User user) {
        userRepo.delete(user);
    }

}