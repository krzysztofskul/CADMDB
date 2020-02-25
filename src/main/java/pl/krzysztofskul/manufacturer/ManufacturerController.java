package pl.krzysztofskul.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private ManufacturerService manufacturerService;
    private ProductCategoryService productCategoryService;
    private ProductService productService;
    private RoomService roomService;

    @Autowired
    public ManufacturerController(
            ManufacturerService manufacturerService,
            ProductCategoryService productCategoryService,
            ProductService productService,
            RoomService roomService
    ) {
        this.manufacturerService = manufacturerService;
        this.productCategoryService = productCategoryService;
        this.productService = productService;
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public String all(
            Model model
    ) {
        model.addAttribute("manufacturers", manufacturerService.loadAllWithProducts());
        model.addAttribute("productCategories", productCategoryService.loadAllWithProducts());
        return "manufacturers/all";
    }

    @GetMapping("/new")
    public String newManufacturer(
            Model model
    ) {
        model.addAttribute("newManufacturer", new Manufacturer());
        return "manufacturers/new";
    }

    @PostMapping("/new")
    public String newManufacturer(
            @ModelAttribute("newManufacturer") Manufacturer manufacturer
    ) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers/all";
    }

    @GetMapping("/productAddToRoom")
    public String productAddToRoom(
            Model model,
            @RequestParam("productId") Long id
    ) {
        model.addAttribute("productToAdd", productService.loadByIdWithRoomList(id));
        model.addAttribute("allRooms", roomService.loadAll());
        return "manufacturers/productAddToRoom";
    }

    @PostMapping("/productAddToRoom")
    public String productAddToRoom(
            @ModelAttribute("productToAdd") Product product,
            @RequestParam("rooms") List<Room> rooms
    ) {
        for (Room room : rooms) {
            productService.addProductToRoom(product.getId(),room.getId());
        }
        productService.save(product);
        return "redirect:/hospitals/all";
    }

}
