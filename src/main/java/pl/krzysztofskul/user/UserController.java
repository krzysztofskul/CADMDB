package pl.krzysztofskul.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysztofskul.user.userCategory.UserCategory;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserCategoryService userCategoryService;

    @Autowired
    public UserController(
            UserService userService,
            UserCategoryService userCategoryService
    ) {
        this.userService = userService;
        this.userCategoryService = userCategoryService;
    }

    @ModelAttribute("userCategoryList")
    public List<UserCategory> getUserCategoryList() {
        return userCategoryService.loadAll();
    }

    @GetMapping("/all")
    public String getUserListAll(
            Model model
    ) {
        model.addAttribute("userList", userService.loadAllWithUserCategoryList());
        return "users/all";
    }

    @GetMapping("/details/{id}")
    public String getUserDetails(
            @PathVariable(name = "id") Long userId,
            Model model
    ) {
        model.addAttribute("user", userService.loadByIdWithHospitalsManagingListAndUserCategoryList(userId));
        return "users/details";
    }
}
