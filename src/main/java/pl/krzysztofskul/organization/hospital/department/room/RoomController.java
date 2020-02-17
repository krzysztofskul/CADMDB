package pl.krzysztofskul.organization.hospital.department.room;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategoryService;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private DepartmentService departmentService;
    private RoomService roomService;
    private RoomCategoryService roomCategoryService;

    @Autowired
    public RoomController(
            DepartmentService departmentService,
            RoomService roomService,
            RoomCategoryService roomCategoryService
    ) {
        this.departmentService = departmentService;
        this.roomService = roomService;
        this.roomCategoryService = roomCategoryService;
    }

    @ModelAttribute("allRoomCategories")
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryService.loadAll();
    }

    @GetMapping("/new")
    public String newRoom(
            Model model,
            @RequestParam(name = "departmentId", required = false) Long id
    ) {
        Room room = new Room();
        if (id != null) {
            room.setDepartment(departmentService.loadByIdWithHospitalAndItsDepartmentList(id));
        }
        model.addAttribute("newRoom", room);
        return "rooms/new";
    }

    @PostMapping("new")
    public String newRoom(
            @ModelAttribute("newRoom") Room room
    ) {
        roomService.save(room);
        return "redirect:/hospitals/all";
    }

}
