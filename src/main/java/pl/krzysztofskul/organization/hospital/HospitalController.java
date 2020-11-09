package pl.krzysztofskul.organization.hospital;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService hospitalService;
    private DepartmentService departmentService;
    private UserService userService;

    public HospitalController(
            HospitalService hospitalService,
            DepartmentService departmentService,
            UserService userService
    ) {
        this.hospitalService = hospitalService;
        this.departmentService = departmentService;
        this.userService = userService;
    }

    @ModelAttribute("allUserList")
    public List<User> getAllUnemployedUserList() {
        List<User> userList = userService.loadAll();
        userList.removeIf(user -> user.getHospital() != null);
        return userList;
    }

    @GetMapping("/new")
    public String newHospital(
            Model model,
            @RequestParam(name = "investorId", required = false) Long investorId,
            @RequestParam(name = "demo", required = false) String demo
    ) {

        Hospital newHospital;

        if (null != demo) {
            LoremIpsum loremIpsum = LoremIpsum.getInstance();
            Random random = new Random();
            HospitalBuilder hospitalBuilder = new HospitalBuilder();
            newHospital = hospitalBuilder
                    .setName(loremIpsum.getTitle(1)+" Demo Hospital ")
                    .setBudget(BigDecimal.valueOf(10000000d+random.nextDouble()*10000000d).setScale(2, RoundingMode.CEILING).round(new MathContext(100, RoundingMode.CEILING)))
                    .setArea(random.nextInt(500)+500)
                    .setCountry(loremIpsum.getCountry())
                    .setPostalCode(loremIpsum.getZipCode())
                    .setCity(loremIpsum.getCity())
                    .setStreet(loremIpsum.getName())
                    .setStreetNo(random.nextInt(100))
                    .setEmail("demo.hospital@example.com")
                    .setPhone(loremIpsum.getPhone())
                    .setWww("www.demo-hospital.com")
                    .setRemarks(loremIpsum.getParagraphs(1, 1))
                    .BuildHospital();
        } else {
            newHospital = new Hospital();
        }

        if (investorId != null) {
            newHospital.setInvestor(userService.loadById(investorId));
        }

        model.addAttribute("hospital", newHospital);
        return "hospitals/new";
    }

    @PostMapping("/new")
    public String newHospital(
            @ModelAttribute("hospital") @Valid Hospital hospital, BindingResult bindingResult,
            @RequestParam(name = "content", required = false) String content,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {

        if (bindingResult.hasErrors()) {
            return "hospitals/new";
        }

        if (hospital.getInvestor() != null) {
            User investor = userService.loadByIdWithHospitalsManagingList(hospital.getInvestor().getId());
            investor.addHospitalToHospitalsAsInvestor(hospital);
            userService.save(investor);
        }


        for (User user : userService.loadAll()) {
            if (user.getHospital() != null && user.getHospital().getId().equals(hospital.getId())) {
                for (User userInHospital : hospital.getUserList()) {
                    if (user.getId().equals(userInHospital.getId())) {
                        break;
                    }
                    user.setHospital(null);
                    userService.save(user);
                }
            }
        }
        if (hospital.getUserList() != null && hospital.getUserList().size() > 0) {
            for (User user : hospital.getUserList()) {
                user.setHospital(hospital);
                userService.save(user);
            }
        }

        if (hospital.getUserList() == null || 0 == hospital.getUserList().size()){
            for (User user : userService.loadAll()) {
                if (user.getHospital() != null) {
                    if (user.getHospital().getId().equals(hospital.getId())) {
                        user.setHospital(null);
                        userService.save(user);
                    }
                }
            }
        }

        hospitalService.save(hospital);
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/hospitals/all";
    }

    @GetMapping("/all")
    public String all(
            Model model
    ) {
        List<Hospital> hospitals = hospitalService.loadAllHospitalsWithDepartments();
        model.addAttribute("hospitals", hospitals);
        return "hospitals/all";
    }

    @GetMapping("/details/{id}")
    public String details(
            @PathVariable Long id,
            Model model
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);
        if (hospital != null) {
            model.addAttribute("hospital", hospital);
            return "hospitals/details";
        } else {
            return "redirect:/errorPage?comment=no-hospital-found";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);

        for (User user : hospital.getUserList()) {
            user.setHospital(null);
        }
        hospitalService.delete(hospital);
        return "redirect:/hospitals/all";
    }

}
