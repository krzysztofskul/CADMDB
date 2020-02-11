package pl.krzysztofskul.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
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

}