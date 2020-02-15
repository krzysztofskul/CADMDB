package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.manufacturer.ManufacturerService;
import pl.krzysztofskul.organization.hospital.Hospital;
import pl.krzysztofskul.organization.hospital.HospitalService;
import pl.krzysztofskul.organization.hospital.department.Department;
import pl.krzysztofskul.organization.hospital.department.DepartmentService;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategory;
import pl.krzysztofskul.organization.hospital.department.departmentCategory.DepartmentCategoryService;
import pl.krzysztofskul.organization.hospital.department.room.Room;
import pl.krzysztofskul.organization.hospital.department.room.RoomService;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategory;
import pl.krzysztofskul.organization.hospital.department.room.roomCategory.RoomCategoryService;
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
    private RoomCategoryService roomCategoryService;
    private DepartmentCategoryService departmentCategoryService;
    private HospitalService hospitalService;
    private DepartmentService departmentService;
    private RoomService roomService;

    @Autowired
    public InitTestDBService(
            UserCategoryService userCategoryService,
            UserService userService,
            ManufacturerService manufacturerService,
            ProductCategoryService productCategoryService,
            ProductService productService,
            RoomCategoryService roomCategoryService,
            DepartmentCategoryService departmentCategoryService,
            HospitalService hospitalService,
            DepartmentService departmentService,
            RoomService roomService
    ) {
        this.userCategoryService = userCategoryService;
        this.userService = userService;
        this.manufacturerService = manufacturerService;
        this.productCategoryService = productCategoryService;
        this.productService = productService;
        this.roomCategoryService = roomCategoryService;
        this.departmentCategoryService = departmentCategoryService;
        this.hospitalService = hospitalService;
        this.departmentService = departmentService;
        this.roomService = roomService;
    }

    public void createUsersCategory() {
        UserCategory userCategory;

        userCategory = new UserCategory();
        userCategory.setCode("ADMIN");
        userCategory.setName("Administrator");
        userCategory.setDescription("Person/User who is the administrator of the web application.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("INVESTOR");
        userCategory.setName("Investor");
        userCategory.setDescription("Person/User who represents the investor of the new hospital investment.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("CONTRACTOR");
        userCategory.setName("Contractor");
        userCategory.setDescription("Person/User who represents the general contractor of the new hospital building process.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("MANAGER");
        userCategory.setName("Manager");
        userCategory.setDescription("Person/User who represents the hospital manager.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("EMPLOYEE");
        userCategory.setName("Employee");
        userCategory.setDescription("Person/User who represents the hospital employee.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("DESIGNER");
        userCategory.setName("Designer");
        userCategory.setDescription("Person/User who represents the designing office, which creates a project of the new hospital building.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("MANUFACTURER");
        userCategory.setName("Manufacturer");
        userCategory.setDescription("Person/User who represents the manufacturer of the hospital devices and equipment.");
        userCategoryService.save(userCategory);

    }

    public void createTestUsers() {
        User user;

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Admin");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("ADMIN"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Investor-First");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("INVESTOR"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Investor-Second");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("INVESTOR"));
        user.setHospital(hospitalService.loadById(Long.parseLong("2")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Contractor");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("CONTRACTOR"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manager");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("MANAGER"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Employee-First");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("EMPLOYEE"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Employee-Second");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("EMPLOYEE"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Designer");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("DESIGNER"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manufacturer 1");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.setUserCategory(userCategoryService.loadByCode("MANUFACTURER"));
        user.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        userService.save(user);

    }

    public void createTestManufacturers() {
        Manufacturer manufacturer;

        for (int i = 1; i <= 2; i++) {
            manufacturer = new Manufacturer();
            manufacturer.setName("Manufacturer no. "+i);
            manufacturer.setDetails("Some details about manufacturer no. "+i+". Country, city, address, contact, etc.");
            manufacturerService.save(manufacturer);
        }

    }

    public void createProductCategories() {
        ProductCategory productCategory;

        productCategory = new ProductCategory();
        productCategory.setCode("OR-T");
        productCategory.setName("Operating Table");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("OR-L");
        productCategory.setName("Operating Lamp");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("OR-A");
        productCategory.setName("Anaesthetic Workstation");
        productCategoryService.save(productCategory);

    }

    public void createTestProducts() {
        Product product;

        /** 1ST TEST MANUFACTURER PRODUCTS */
        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Alpha");
        product.setPrice(BigDecimal.valueOf(50000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Beta");
        product.setPrice(BigDecimal.valueOf(75000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("HALOGEN");
        product.setPrice(BigDecimal.valueOf(40000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("LED");
        product.setPrice(BigDecimal.valueOf(90000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));
        productService.save(product);

        /** 2ND TEST MANUFACTURER PRODUCTS */
        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Uno");
        product.setPrice(BigDecimal.valueOf(50000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-T"));
        product.setModelName("Duo");
        product.setPrice(BigDecimal.valueOf(75000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("2xHALOGEN");
        product.setPrice(BigDecimal.valueOf(80000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-L"));
        product.setModelName("2xLED");
        product.setPrice(BigDecimal.valueOf(160000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("OR-A"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));
        productService.save(product);

    }

    public void createRoomCategories() {
        RoomCategory roomCategory;

        roomCategory = new RoomCategory();
        roomCategory.setCode("OR-S");
        roomCategory.setName("Operating Room / Srugical");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("OR-NS");
        roomCategory.setName("Operating Room / Neuro-Srugical");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("OR-SP");
        roomCategory.setName("Surgeon preparation room");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("OR-PP");
        roomCategory.setName("Patient preparation room");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("ICR1");
        roomCategory.setName("Intensive Care Room / 1 bed");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("ICR2");
        roomCategory.setName("Intensive Care Room / 2 beds");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("CSSD-C");
        roomCategory.setName("Cleaning Room");
        roomCategoryService.save(roomCategory);

        roomCategory = new RoomCategory();
        roomCategory.setCode("CSSD-S");
        roomCategory.setName("Sterilization Room");
        roomCategoryService.save(roomCategory);

    }

    public void createDepartmentCategories() {
        DepartmentCategory departmentCategory;

        departmentCategory = new DepartmentCategory();
        departmentCategory.setCode("OT");
        departmentCategory.setName("Operating Theater");
        departmentCategoryService.save(departmentCategory);

        departmentCategory = new DepartmentCategory();
        departmentCategory.setCode("ICU");
        departmentCategory.setName("Intensive Care Unit");
        departmentCategoryService.save(departmentCategory);

        departmentCategory = new DepartmentCategory();
        departmentCategory.setCode("CSSD");
        departmentCategory.setName("Central Sterile Service Department");
        departmentCategoryService.save(departmentCategory);

    }

    public void createTestHospitals() {
        Hospital hospital;

        hospital = new Hospital();
        hospital.setName("Hospital Test No. 1");
        hospital.setBudget(BigDecimal.valueOf(10000000.00));
        hospital.addUser(userService.loadByEmail("GuestInvestor-First@test.test"));
        hospital.addUser(userService.loadByEmail("GuestEmployee-First@test.test"));
        hospitalService.save(hospital);

        hospital = new Hospital();
        hospital.setName("Hospital Test No. 2");
        hospital.setBudget(BigDecimal.valueOf(20000000.00));
        hospital.addUser(userService.loadByEmail("GuestInvestor-Second@test.test"));
        hospital.addUser(userService.loadByEmail("GuestEmployee-Second@test.test"));
        hospitalService.save(hospital);

    }

    public void createTestDepartments() {
        Department department;

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("1")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("OT"));
        department.setBudget(BigDecimal.valueOf(5000000.00));
        departmentService.save(department);

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("1")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("ICU"));
        department.setBudget(BigDecimal.valueOf(4000000.00));
        departmentService.save(department);

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("2")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("OT"));
        department.setBudget(BigDecimal.valueOf(600000.00));
        departmentService.save(department);

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("2")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("CSSD"));
        department.setBudget(BigDecimal.valueOf(400000.00));
        departmentService.save(department);

    }

    public void createTestRooms() {
        Room room;

        room = new Room();
        room.setNumber("1.1.1");
        room.setDepartment(departmentService.loadById(Long.valueOf("1")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-S"));
        room.setBudget(BigDecimal.valueOf(500000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("1.1.2");
        room.setDepartment(departmentService.loadById(Long.valueOf("1")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-SP"));
        room.setBudget(BigDecimal.valueOf(300000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("1.1.3");
        room.setDepartment(departmentService.loadById(Long.valueOf("1")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-PP"));
        room.setBudget(BigDecimal.valueOf(200000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("1.2.1");
        room.setDepartment(departmentService.loadById(Long.valueOf("2")));
        room.setRoomCategory(roomCategoryService.loadByCode("ICR1"));
        room.setBudget(BigDecimal.valueOf(400000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("2.1.1");
        room.setDepartment(departmentService.loadById(Long.valueOf("3")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-NS"));
        room.setBudget(BigDecimal.valueOf(500000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("2.1.2");
        room.setDepartment(departmentService.loadById(Long.valueOf("3")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-SP"));
        room.setBudget(BigDecimal.valueOf(350000.00));
        roomService.save(room);

        room = new Room();
        room.setNumber("2.1.3");
        room.setDepartment(departmentService.loadById(Long.valueOf("3")));
        room.setRoomCategory(roomCategoryService.loadByCode("OR-PP"));
        room.setBudget(BigDecimal.valueOf(250000.00));
        roomService.save(room);

    }

    public void addTestProductsToTestRooms() {
        Room room;

        room = roomService.loadById(Long.valueOf("1"));
        productService.addProductToRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        productService.removeProductFromRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        roomService.save(room);

        room = roomService.loadById(Long.valueOf("5"));
        productService.addProductToRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("3")).getId(), room.getId());
        roomService.save(room);
    }
}