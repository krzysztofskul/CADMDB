package pl.krzysztofskul.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysztofskul.user.userCategory.UserCategory;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByUserCategory(UserCategory userCategory);

}