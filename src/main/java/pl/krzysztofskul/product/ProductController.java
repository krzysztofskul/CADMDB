package pl.krzysztofskul.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krzysztofskul.ProductManager;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.manufacturer.ManufacturerService;
import pl.krzysztofskul.product.productCategory.ProductCategory;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ManufacturerService manufacturerService;
    private ProductService productService;
    private ProductManager productManager;
    private ProductCategoryService productCategoryService;

    public ProductController(
            ManufacturerService manufacturerService,
            ProductService productService,
            ProductManager productManager,
            ProductCategoryService productCategoryService
    ) {
        this.manufacturerService = manufacturerService;
        this.productService = productService;
        this.productManager = productManager;
        this.productCategoryService = productCategoryService;
    }

    @ModelAttribute("allManufacturers")
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.loadAll();
    }

    @ModelAttribute("allProductCategories")
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.loadAllWithProducts();
    }

    @GetMapping("/all")
    public String all() {
        return "products/all";
    }

    @GetMapping("/{id}")
    public String getProductDetailsById(
            @PathVariable(name = "id") Long id,
            Model model
    ) {
        model.addAttribute("product", productService.loadByIdWithRoomList(id));
        return "products/details";
    }

    @GetMapping("/new")
    public String newProduct(
            Model model,
            @RequestParam(name = "manufacturerId", required = false) Long id
    ) {
        Product newProduct = new Product();
        if (id != null) {
            newProduct.setManufacturer(manufacturerService.loadById(id));
        }
        model.addAttribute("newProduct", newProduct);
        return "products/new";
    }

    @PostMapping("/new")
    public String newProduct(
            @ModelAttribute("newProduct")Product product
    ) {
        productService.save(product);
        return "redirect:/manufacturers/all";
    }

    @GetMapping("/delete/{productId}/from/{roomId}")
    public String deleteProductFromRoom(
            @PathVariable Long productId,
            @PathVariable Long roomId,
            @RequestParam String backToPage
    ) {
        productManager.removeProductFromRoom(productId, roomId);
        return "redirect:"+backToPage;
    }

}