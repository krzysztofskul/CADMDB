package pl.krzysztofskul.user.userCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCategoryService {

    private UserCategoryRepo userCategoryRepo;

    @Autowired
    public UserCategoryService(UserCategoryRepo userCategoryRepo) {
        this.userCategoryRepo = userCategoryRepo;
    }

    public void save(UserCategory userCategory) {
        userCategoryRepo.save(userCategory);
    }

    public List<UserCategory> loadAll() {
        return userCategoryRepo.findAll();
    }

    public UserCategory loadById(Long id) {
        return userCategoryRepo.findById(id).get();
    }

    public UserCategory loadByCode(String code) {
        return userCategoryRepo.findByCode(code);
    }

    public void delete(UserCategory userCategory) {
        userCategoryRepo.delete(userCategory);
    }

}
