package pl.krzysztofskul.organization.hospital.department.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.manufacturer.ManufacturerService;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategoryService;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatus;
import pl.krzysztofskul.organization.organizationStatus.OrganizationStatusService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private UserService userService;
    private DepartmentService departmentService;
    private RoomService roomService;
    private RoomCategoryService roomCategoryService;
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private ManufacturerService manufacturerService;
    private OrganizationStatusService organizationStatusService;

    @Autowired
    public RoomController(
            UserService userService,
            DepartmentService departmentService,
            RoomService roomService,
            RoomCategoryService roomCategoryService,
            ProductService productService,
            ProductCategoryService productCategoryService,
            ManufacturerService manufacturerService,
            OrganizationStatusService organizationStatusService
    ) {
        this.userService = userService;
        this.departmentService = departmentService;
        this.roomService = roomService;
        this.roomCategoryService = roomCategoryService;
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.manufacturerService = manufacturerService;
        this.organizationStatusService = organizationStatusService;
    }

    @ModelAttribute("allRoomCategories")
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryService.loadAll();
    }

    @ModelAttribute("userHospitalManagerList")
    public List<User> getUserHospitalManagerList() {
        return userService.loadUserHospitalManagerList();
    }

    @ModelAttribute("organizationStatusList")
    public List<OrganizationStatus> getAllOrganizationStatusList() {

        List<OrganizationStatus> organizationStatusList = organizationStatusService.loadAll();
        Collections.sort(organizationStatusList, (o1, o2) -> o1.getSequence()-o2.getSequence());

        return organizationStatusList;
    }

    @GetMapping("/new")
    public String newRoom(
            Model model,
            @RequestParam(name = "departmentId", required = false) Long id,
            @RequestParam(name = "backToPage") String backToPage
    ) {
        Room room = new Room();
        if (id != null) {
            room.setDepartment(departmentService.loadByIdWithHospitalAndItsDepartmentList(id));
        }
        model.addAttribute("room", room);
        model.addAttribute("backToPage", backToPage);
        return "rooms/new";
    }

    @PostMapping("new")
    public String newRoom(
            @ModelAttribute("room") Room room,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {
        if (null == room.getUserManager().getId()) {
            room.setUserManager(null);
        }
        roomService.save(room);
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/hospitals/all";
    }

    @GetMapping("/details/{id}")
    public String getRoomDetails(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "content", required = false) String content,
            Model model
    ) {
        Room room;
        if (content == null) {
            content = "info";
        }
        switch (content) {
            case "info":
                room = roomService.loadByIdWithUsers(id);
                break;
            case "productList":
            case "analysis":
                room = roomService.loadByIdWithProducts(id);
                break;
            default:
                return "redirect:/errorPage?comment=no-page-or-room-found";
        }
        if (room != null) {
            model.addAttribute("hospitalOrgUnit", room);
            return "hospital-org-unit-details";
        } else {
            return "redirect:/errorPage?comment=no-room-found";
        }
    }

    @GetMapping("/addProduct")
    public String roomAddProduct(
            Model model,
            @RequestParam(name = "roomId", required = true) Long roomId
    ) {
        Room room = roomService.loadByIdWithProducts(roomId);
        model.addAttribute("room", room);
        model.addAttribute("allProducts", productService.loadAllSorted());
        model.addAttribute("productCategoryList", productCategoryService.loadAll());
        return "rooms/addProduct";
    }

    @PostMapping("addProduct")
    public String roomAddProduct(
            @ModelAttribute("room") Room room,
            @RequestParam("productToAdd") List<Product> productsToAdd,
            @RequestParam(name = "backToPage", required = false) String backToPage
    ) {
        for (Product productToAdd : productsToAdd) {
            productService.addProductToRoom(productToAdd.getId(), room.getId());
        }
        if (backToPage != null) {
            return "redirect:"+backToPage;
        }
        return "redirect:/hospitals/all";
    }

    @GetMapping("/changeProduct")
    public String changeProduct(
            @RequestParam(name = "roomId") Long roomId,
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "category") String productCategoryCode,
            Model model
    ) {
        Room room = roomService.loadByIdWithProducts(roomId);
        List<Product> productList = productService.loadAllByCategoryCode(productCategoryCode);
        model.addAttribute("productToDelId", productId);
        model.addAttribute("room", room);
        model.addAttribute("productList", productList);
        model.addAttribute("category", productCategoryCode);
        return "rooms/addProductByCategoryToRoom";
    }

    @PostMapping("/changeProduct")
    public String changeProduct(
            @RequestParam(name = "productNewId") Long productNewId,
            @RequestParam(name = "productToDelId") Long productToDelId,
            @ModelAttribute(name = "room") Room room
    ) {
        productService.removeProductFromRoom(productToDelId, room.getId());
        productService.addProductToRoom(productNewId, room.getId());
        return "redirect:/rooms/details/"+room.getId();
    }

    @GetMapping("/delete/{roomId}")
    public String deleteRoom(
            @PathVariable Long roomId,
            @RequestParam String backToPage
    ) {
        roomService.delete(roomService.loadById(roomId));
        return "redirect:"+backToPage;
    }

    @GetMapping("/delete/{roomId}/{productId}")
    public String deleteProductFromRoom(
        @PathVariable(name = "roomId") Long roomId,
        @PathVariable(name = "productId") Long productId,
        @RequestParam(name = "backToPage") String backToPage
    ) {
        productService.removeProductFromRoom(productId, roomId);
        return "redirect:/"+backToPage;
    }

}
