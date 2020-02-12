package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.manufacturer.ManufacturerService;
import pl.krzysztofskul.product.Product;
import pl.krzysztofskul.product.ProductService;
import pl.krzysztofskul.product.productCategory.ProductCategory;
import pl.krzysztofskul.product.productCategory.ProductCategoryService;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserService;
import pl.krzysztofskul.user.userCategory.UserCategory;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import java.math.BigDecimal;

@Service
@Transactional
public class InitTestDBService {

    private UserCategoryService userCategoryService;
    private UserService userService;
    private ManufacturerService manufacturerService;
    private ProductCategoryService productCategoryService;
    private ProductService productService;

    @Autowired
    public InitTestDBService(
            UserCategoryService userCategoryService,
            UserService userService,
            ManufacturerService manufacturerService,
            ProductCategoryService productCategoryService,
            ProductService productService
    ) {
        this.userCategoryService = userCategoryService;
        this.userService = userService;
        this.manufacturerService = manufacturerService;
        this.productCategoryService = productCategoryService;
        this.productService = productService;
    }

    public void createUsersCategory() {
        UserCategory userCategory = new UserCategory();

        userCategory.setCode("ADMIN");
        userCategory.setName("Administrator");
        userCategory.setDescription("Person/User who is the administrator of the web application.");
        userCategoryService.save(userCategory);

        userCategory.setCode("INVESTOR");
        userCategory.setName("Investor");
        userCategory.setDescription("Person/User who represents the investor of the new hospital investment.");
        userCategoryService.save(userCategory);

        userCategory.setCode("CONTRACTOR");
        userCategory.setName("Contractor");
        userCategory.setDescription("Person/User who represents the general contractor of the new hospital building process.");
        userCategoryService.save(userCategory);

        userCategory.setCode("MANAGER");
        userCategory.setName("Manager");
        userCategory.setDescription("Person/User who represents the hospital manager.");
        userCategoryService.save(userCategory);

        userCategory.setCode("EPLOYEE");
        userCategory.setName("Employee");
        userCategory.setDescription("Person/User who represents the hospital employee.");
        userCategoryService.save(userCategory);

        userCategory.setCode("DESIGNER");
        userCategory.setName("Designer");
        userCategory.setDescription("Person/User who represents the designing office, which creates a project of the new hospital building.");
        userCategoryService.save(userCategory);

        userCategory.setCode("MANUFACTURER");
        userCategory.setName("Manufacturer");
        userCategory.setDescription("Person/User who represents the manufacturer of the hospital devices and equipment.");
        userCategoryService.save(userCategory);

    }

    public void createTestUsers() {
        User user = new User();

        user.setNameFirst("Guest");
        user.setNameLast("Some-Admin");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("ADMIN"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Investor");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("INVESTOR"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Contractor");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("CONTRACTOR"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Manager");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("MANAGER"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Employee");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("EMPLOYEE"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Designer");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("DESIGNER"));
        userService.save(user);

        user.setNameFirst("Guest");
        user.setNameLast("Some-Manufacturer 1");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("MANUFACTURER"));
        user.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        userService.save(user);

    }

    public void createTestManufacturers() {
        Manufacturer manufacturer = new Manufacturer();

        for (int i = 1; i <= 2; i++) {
            manufacturer.setName("Manufacturer no. "+i);
            manufacturer.setDetails("Some details about manufacturer no. "+i+". Country, city, address, contact, etc.");
            manufacturerService.save(manufacturer);
        }

    }

    public void createProducCategories() {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setCode("OR-T");
        productCategory.setName("Operating Table");
        productCategoryService.save(productCategory);

        productCategory.setCode("OR-L");
        productCategory.setName("Operating Lamp");
        productCategoryService.save(productCategory);

        productCategory.setCode("OR-A");
        productCategory.setName("Anaesthetic Workstation");
        productCategoryService.save(productCategory);

    }

    public void createTestProducts() {
        Product product = new Product();

        /** 1ST TEST MANUFACTURER PRODUCTS */
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Alpha");
        product.setPrice(BigDecimal.valueOf(50000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Beta");
        product.setPrice(BigDecimal.valueOf(75000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("HALOGEN");
        product.setPrice(BigDecimal.valueOf(40000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("LED");
        product.setPrice(BigDecimal.valueOf(90000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));

        /** 2ND TEST MANUFACTURER PRODUCTS */
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Uno");
        product.setPrice(BigDecimal.valueOf(50000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Duo");
        product.setPrice(BigDecimal.valueOf(75000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("2xHALOGEN");
        product.setPrice(BigDecimal.valueOf(80000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("2xLED");
        product.setPrice(BigDecimal.valueOf(160000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));

        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));

    }

}