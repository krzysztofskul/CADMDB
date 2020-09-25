package pl.krzysztofskul.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;

import javax.servlet.http.HttpSession;

@Controller
public class LogInController {

    private UserService userService;

    @Autowired
    public LogInController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/register")

//    @GetMapping("/login")

    @GetMapping("/loginAsGuest/hospital-manager-guest")
    public String loginAsGuest(
            HttpSession httpSession
    ) {
        httpSession.setAttribute("userLoggedIn", userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST));
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logOut(
            HttpSession httpSession
    ) {
        httpSession.removeAttribute("userLoggedIn");
        return "redirect:/";
    }

}
