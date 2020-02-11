package pl.krzysztofskul.user.userCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepo extends JpaRepository<UserCategory, Long> {

    UserCategory findByCode(String code);

}