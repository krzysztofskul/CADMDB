package pl.krzysztofskul.organization.hospital.department.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategoryService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;

import java.util.Collections;
import java.util.Comparator;
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
            ProductService productService,
            ProductCategoryService productCategoryService
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
//        room.setDepartment(departmentService.loadByIdWithHospitalAndItsDepartmentList(room.getDepartment().getId()));
        roomService.save(room);
        return "redirect:/hospitals/all";
    }

    @GetMapping("/details/{id}")
    public String getRoomDetails(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "content", required = false) String content,
            Model model
    ) {
        if ("analysis".equals(content)) {
            model.addAttribute("content", "analysis");
        }
        if ("productList".equals(content)) {
            model.addAttribute("content", "productList");
        }
        if ("info".equals(content)) {
            model.addAttribute("content", "info");
        }
        Room room = roomService.loadByIdWithProducts(id);
        Collections.sort(room.getProductList(), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductCategory().getCode().compareTo(o2.getProductCategory().getCode());
            }
        });
        model.addAttribute(room);
        return "rooms/details";
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
