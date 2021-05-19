package pl.krzysztofskul.organization.hospital;

import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
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
        List<User> userList = userService.loadAllWithHospitalManagingList();
        userList.removeIf(user -> user.getHospital() != null);
        userList.removeIf(user -> user.getHospitalManagingList().size() > 0);
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
            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model,
            @RequestParam Map<String, String> allParams
    ) {

        Map<String, String> allParamsCheck = allParams;

        if (bindingResult.hasErrors()) {
            if (backToPage.contains("/hospitals/details")) {
                model.addAttribute("hospital", hospital);
                //return "hospitals/details";
                return "hospitals/details/"+hospital.getId()+"?content=info&edit=true&editUsers=true";
            } else if (null != content && content.contains("info")) {
                return "details-deprecated20210518";
            } else {
                return "hospitals/new";
            }

        }

        if (hospital.getInvestor() != null) {
            User investor = userService.loadByIdWithHospitalsManagingList(hospital.getInvestor().getId());
            investor.addHospitalToHospitalsAsInvestor(hospital);
            userService.save(investor);
        }


        for (User user : userService.loadAll()) {
            if (user.getHospital() != null && user.getHospital().getId().equals(hospital.getId())) {
                for (User userInHospital : hospital.getEmployeeList()) {
                    if (user.getId().equals(userInHospital.getId())) {
                        break;
                    }
                    user.setHospital(null);
                    userService.save(user);
                }
            }
        }
        if (hospital.getEmployeeList() != null && hospital.getEmployeeList().size() > 0) {
            for (User user : hospital.getEmployeeList()) {
                user.setHospital(hospital);
                userService.save(user);
            }
        }

        if (hospital.getEmployeeList() == null || 0 == hospital.getEmployeeList().size()){
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
            Model model,
            @RequestParam(name = "content", required = false) String content,
            @RequestParam(name = "edit", required = false) boolean edit,
            @RequestParam(name = "editUsers", required = false) boolean editUsers
    ) {
        Hospital hospital;
        switch (content) {
            case "info":
                hospital = hospitalService.loadByIdWithUsers(id);
                break;
            case "departmentList":
                hospital = hospitalService.loadByIdWithDepartments(id);
                break;
            case "analysis":
                hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);
                break;
            default:
                return "redirect:/errorPage?comment=no-page-or-hospital-found";
        }
        if (hospital != null) {
            // old:
            //model.addAttribute("hospital", hospital);
            //return "hospitals/details";
            // new:
            model.addAttribute("hospitalOrgUnit", hospital);
            return "hospital-org-unit-details";
        } else {
            return "redirect:/errorPage?comment=no-hospital-found";
        }
    }

    @PostMapping("/details")
    public String newHospital(
            @ModelAttribute("hospital") @Valid Hospital hospital, BindingResult bindingResult,
            @RequestParam(name = "content", required = false) String content,
            @RequestParam(name = "backToPage", required = false) String backToPage,
            Model model,
            HttpSession httpSession
    ) {

        if (bindingResult.hasErrors()) {
            if (backToPage.contains("/hospitals/details")) {
                model.addAttribute("hospital", hospital);
                //http://localhost:8080
                List<ObjectError> validationErrors = bindingResult.getAllErrors();
                httpSession.setAttribute("validationErrors", validationErrors);
                return "redirect:/hospitals/details/"+hospital.getId()+"?content=info&edit=true&editUsers=true";
            }

        }
        httpSession.setAttribute("validationErrors", null);
        hospitalService.save(hospital);
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/users/details/"+hospital.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsersWithDepartmentsItsRoomsAndItsProducts(id);

        for (User user : hospital.getEmployeeList()) {
            user.setHospital(null);
        }
        hospitalService.delete(hospital);
        return "redirect:/hospitals/all";
    }

    @GetMapping("/{hospitalId}/setManager")
    public String setManager(
            @PathVariable("hospitalId") Long hospitalId,
            @RequestParam(name = "userId", required = false) Long userId,
            Model model
    ) {

        if (null == userId) {
            model.addAttribute("hospital", hospitalService.loadById(hospitalId));
            model.addAttribute("users", userService.loadAll());
            return "hospitals/set-manager";
        } else {
            Hospital hospital = hospitalService.loadById(hospitalId);
            hospital.setManager(userService.loadById(userId));
            hospitalService.save(hospital);
            return "redirect:/hospitals/details/" + hospitalId;
        }
    }

    @GetMapping("/{hospitalId}/dismissManager")
    public String dismissManager(
          @PathVariable("hospitalId") Long hospitalId
    ) {
            Hospital hospital = hospitalService.loadById(hospitalId);
            hospital.setManager(null);
            hospitalService.save(hospital);

            return "redirect:/hospitals/details/"+hospitalId;
    }

    @GetMapping("/{hospitalId}/addEmployee")
    public String addUser(
            @PathVariable("hospitalId") Long hospitalId,
            @RequestParam(name = "userId", required = false) Long userId,
            Model model
    ) {
        Hospital hospital = hospitalService.loadByIdWithUsers(hospitalId);
        if (null != userId) {
            //hospital.addUser(userService.loadById(userId));
            //hospitalService.save(hospital);
            User user = userService.loadById(userId);
            user.setHospital(hospitalService.loadById(hospitalId));
            userService.save(user);
        } else {
            model.addAttribute("hospital", hospital);
            model.addAttribute("users", userService.loadAllUnemployed());
            return "hospitals/add-employee";
        }
        return "redirect:/hospitals/details/"+hospitalId;

    }

    @GetMapping("/{hospitalId}/dismissEmployee")
    public String dismissEmployee(
            @PathVariable("hospitalId") Long hospitalId,
            @RequestParam("userId") Long userId
    ) {
        User user = userService.loadById(userId);
        user.setHospital(null);
        userService.save(user);
        return "redirect:/hospitals/details/"+hospitalId;
    }

}
