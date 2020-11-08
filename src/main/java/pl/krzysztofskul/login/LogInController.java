package pl.krzysztofskul.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krzysztofskul.user.User;
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
    public String loginAsHospiptalManagerGuest(
            HttpSession httpSession
    ) {
        httpSession.setAttribute("userLoggedIn", userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST));
        User userLoggedIn = (User) httpSession.getAttribute("userLoggedIn");
        return "redirect:/users/details/"+userLoggedIn.getId();
    }

    @GetMapping("/loginAsGuest/investor-guest")
    public String loginAsInvestorGuest(
            HttpSession httpSession
    ) {
        httpSession.setAttribute("userLoggedIn", userService.loadByUserCategoryEnum(UserCategoryEnum.INVESTOR_GUEST));
        User userLoggedIn = (User) httpSession.getAttribute("userLoggedIn");
        return "redirect:/users/details/"+userLoggedIn.getId();
    }

    @GetMapping("/logout")
    public String logOut(
            HttpSession httpSession
    ) {
        httpSession.removeAttribute("userLoggedIn");
        return "redirect:/";
    }

}
