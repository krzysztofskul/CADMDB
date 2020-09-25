package pl.krzysztofskul.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getUserListAll(
            Model model
    ) {
        model.addAttribute("userList", userService.loadAll());
        return "users/all";
    }

    @GetMapping("/details/{id}")
    public String getUserDetails(
            @PathVariable(name = "id") Long userId,
            Model model
    ) {
        model.addAttribute("user", userService.loadById(userId));
        return "users/details";
    }
}
