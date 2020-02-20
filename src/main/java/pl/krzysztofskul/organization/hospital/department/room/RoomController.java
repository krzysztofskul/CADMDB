package pl.krzysztofskul.organization.hospital.department.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategoryService;
import pl.krzysztofskul.product.ProductService;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private DepartmentService departmentService;
    private RoomService roomService;
    private RoomCategoryService roomCategoryService;
    private ProductService productService;

    @Autowired
    public RoomController(
            DepartmentService departmentService,
            RoomService roomService,
            RoomCategoryService roomCategoryService,
            ProductService productService
    ) {
        this.departmentService = departmentService;
        this.roomService = roomService;
        this.roomCategoryService = roomCategoryService;
        this.productService = productService;
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

    @GetMapping("/addProduct")
    public String roomAddProduct(
            Model model,
            @RequestParam(name = "roomId", required = true) Long roomId
    ) {
        Room room = roomService.loadByIdWithProducts(roomId);
        model.addAttribute("room", room);
        model.addAttribute("allProducts", productService.loadAll());

        return "rooms/addProduct";
    }

    @PostMapping("addProduct")
    public String roomAddProduct(
            @ModelAttribute("room") Room room
    ) {
        roomService.save(room);
        return "redirect:/hospitals/all";
    }

}
