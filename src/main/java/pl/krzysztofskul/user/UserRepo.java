package pl.krzysztofskul.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.krzysztofskul.user.userCategory.UserCategory;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

    //List<User> findAllByUserCategory(UserCategory userCategory);
    List<User> findAllByUserCategoryListContains(UserCategory userCategory);

    //User findByUserCategory(UserCategory userCategory);

    //User findByUserCategoryListExists(UserCategory userCategory);

    //User findByUserCategoryListIsContaining(UserCategory userCategory);

    User findByUserCategoryListContains(UserCategory userCategory);

//    @Query("select u from User  where u.hospital is null ")
//    List<User> loadAllUnemployed();
//
//    @Query(value = "SELECT * FROM User WHERE Hospital IS NULL ", nativeQuery = true)
//    List<User> loadAllUnemployedByNativeQuery();

}