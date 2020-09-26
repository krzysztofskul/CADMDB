package pl.krzysztofskul.initTestDB;

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
import pl.krzysztofskul.user.userCategory.UserCategoryEnum;
import pl.krzysztofskul.user.userCategory.UserCategoryService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

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

//        userCategory = new UserCategory();
//        userCategory.setCode("ADMIN");
//        userCategory.setName("Administrator");
//        userCategory.setDescription("Person/User who is the administrator of the web application.");
//        userCategoryService.save(userCategory);

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
        userCategory.setCode("HOSPITAL-MANAGER");
        userCategory.setName("Manager");
        userCategory.setDescription("Person/User who represents the hospital manager.");
        userCategoryService.save(userCategory);

        userCategory = new UserCategory();
        userCategory.setCode("HOSPITAL-EMPLOYEE");
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

    public void createInitTestUsersCategory() {
        for (UserCategory userCategory : InitTestDB.getInitTestDBInstance().getInitTestUserCategories()) {
            userCategoryService.save(userCategory);
        }
    }

    public void createTestUsers() {
        User user;

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Admin");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("ADMIN"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Investor-First");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("INVESTOR"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Investor-Second");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("INVESTOR"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("2")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Contractor");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("CONTRACTOR"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manager");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("HOSPITAL-MANAGER"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manager-2");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("HOSPITAL-MANAGER"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manager-3");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("HOSPITAL-MANAGER"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Employee-First");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("HOSPITAL-EMPLOYEE"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Employee-Second");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("HOSPITAL-EMPLOYEE"));
//        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Designer");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("DESIGNER"));
        userService.save(user);

        user = new User();
        user.setNameFirst("Guest");
        user.setNameLast("Some-Manufacturer 1");
        user.setEmail(user.getNameFirst()+user.getNameLast()+"@test.test");
        user.setPassword("test");
        user.addUserCategory(userCategoryService.loadByCode("MANUFACTURER"));
//        user.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        userService.save(user);

    }

    public void createInitTestUsers() {
        for (User user : InitTestDB.getInitTestDBInstance().getInitTestUsers(userCategoryService.loadAll())) {
            userService.save(user);
        }
    }

    public void createTestManufacturers() {
        /*Manufacturer manufacturer;

        for (int i = 1; i <= 2; i++) {
            manufacturer = new Manufacturer();
            manufacturer.setName("Manufacturer no. "+i);
            manufacturer.setDescription("Some details about manufacturer no. "+i+". Country, city, address, contact, etc.");
            manufacturerService.save(manufacturer);
        }*/

        List<Manufacturer> manufacturerInitList = InitTestDB.getInitTestDBInstance().getInitTestManufacturers(10);
        for (Manufacturer manufacturerInit : manufacturerInitList) {
            manufacturerService.save(manufacturerInit);
        }
    }

    public void createProductCategories() {
        ProductCategory productCategory;

        productCategory = new ProductCategory();
        productCategory.setCode("AA0000");
        productCategory.setName("HOSPITAL BEDS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AB1000");
        productCategory.setName("OPERATING TABLES");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AC1000");
        productCategory.setName("OPERATING LIGHTS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE1000");
        productCategory.setName("MRI SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE2010");
        productCategory.setName("SPECT SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE2020");
        productCategory.setName("PET SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3001");
        productCategory.setName("CT SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3000");
        productCategory.setName("X-RAY SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3001");
        productCategory.setName("CT SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE7000");
        productCategory.setName("ULTRASOUND SYSTEMS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AH1000");
        productCategory.setName("ANAESTHETIC WORKSTATIONS");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AZ000");
        productCategory.setName("MEDICAL SUPPLY SESTEMS");
        productCategoryService.save(productCategory);

    }

    public void createTestProducts() {
        Product product;

        /** 1ST TEST MANUFACTURER PRODUCTS */
        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AB1000"));
        product.setModelName("Alpha");
        product.setPrice(BigDecimal.valueOf(50000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AB1000"));
        product.setModelName("Beta");
        product.setPrice(BigDecimal.valueOf(75000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AC1000"));
        product.setModelName("HALOGEN");
        product.setPrice(BigDecimal.valueOf(40000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AC1000"));
        product.setModelName("LED");
        product.setPrice(BigDecimal.valueOf(90000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AH1000"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("1")));
        product.setProductCategory(productCategoryService.loadByCode("AH1000"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));
        productService.save(product);

        /** 2ND TEST MANUFACTURER PRODUCTS */
        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AB1000"));
        product.setModelName("Uno");
        product.setPrice(BigDecimal.valueOf(50000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AB1000"));
        product.setModelName("Duo");
        product.setPrice(BigDecimal.valueOf(75000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AC1000"));
        product.setModelName("2xHALOGEN");
        product.setPrice(BigDecimal.valueOf(80000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AC1000"));
        product.setModelName("2xLED");
        product.setPrice(BigDecimal.valueOf(160000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AH1000"));
        product.setModelName("Fixed");
        product.setPrice(BigDecimal.valueOf(120000.00));
        productService.save(product);

        product = new Product();
        product.setManufacturer(manufacturerService.loadById(Long.parseLong("2")));
        product.setProductCategory(productCategoryService.loadByCode("AH1000"));
        product.setModelName("Mobile");
        product.setPrice(BigDecimal.valueOf(130000.00));
        productService.save(product);

    }

    public void createInitTestProductsForTestManufacturers() {

        for(int i = 0; i < 4; i++) {
            Manufacturer manufacturer = manufacturerService.loadById(Long.parseLong(String.valueOf(i+1)));

            List<Product> productListAA0000 = InitTestDB.getInitTestDBInstance().getInitTestProducts(productCategoryService.loadByCode("AA0000"));
            List<Product> productListAB1000 = InitTestDB.getInitTestDBInstance().getInitTestProducts(productCategoryService.loadByCode("AB1000"));
            List<Product> productListAC1000 = InitTestDB.getInitTestDBInstance().getInitTestProducts(productCategoryService.loadByCode("AC1000"));
            List<Product> productListAH1000 = InitTestDB.getInitTestDBInstance().getInitTestProducts(productCategoryService.loadByCode("AH1000"));

            for (Product product : productListAA0000) {
                manufacturer.addProduct(product);
            };
            for (Product product : productListAB1000) {
                manufacturer.addProduct(product);
            };
            for (Product product : productListAC1000) {
                manufacturer.addProduct(product);
            };
            for (Product product : productListAH1000) {
                manufacturer.addProduct(product);
            };

            manufacturerService.save(manufacturer);

        }

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
        User user;

        hospital = new Hospital();
        hospital.setName("Hospital Test No. 1");
        hospital.setBudget(BigDecimal.valueOf(10000000.00));
//        hospital.setManager(userService.loadById(Long.parseLong("1")));
        hospital.setManager(userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST));
        hospital.addUser(userService.loadById(Long.parseLong("2")));
        hospital.addUser(userService.loadById(Long.parseLong("3")));
        hospital.setArea(500f);
        hospital.setRemarks("Etiam commodo, est a leo. Mauris nec tristique senectus et.");
        hospitalService.save(hospital);

        user = userService.loadById(Long.parseLong("2"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);
        user = userService.loadById(Long.parseLong("3"));
        user.setHospital(hospitalService.loadById(Long.parseLong("1")));
        userService.save(user);

        hospital = new Hospital();
        hospital.setName("Hospital Test No. 2");
        hospital.setBudget(BigDecimal.valueOf(20000000.00));
        hospital.setManager(userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST));
        hospital.addUser(userService.loadById(Long.parseLong("10")));
        hospital.addUser(userService.loadById(Long.parseLong("9")));
        hospitalService.save(hospital);

        user = userService.loadById(Long.parseLong("10"));
        user.setHospital(hospitalService.loadById(Long.parseLong("2")));
        userService.save(user);
        user = userService.loadById(Long.parseLong("9"));
        user.setHospital(hospitalService.loadById(Long.parseLong("2")));
        userService.save(user);

    }

    public void createTestDepartments() {
        Department department;

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("1")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("OT"));
        department.setBudget(BigDecimal.valueOf(5000000.00));
        //department.setUserManager(userService.loadById(Long.parseLong("5")));
        department.setUserManager(userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST));
        department.setArea(250.0f);
        department.setRemarks("Vivamus vitae lorem nec tincidunt lorem, at risus sit amet neque vitae felis.");
        departmentService.save(department);

        department = new Department();
        department.setHospital(hospitalService.loadById(Long.valueOf("1")));
        department.setDepartmentCategory(departmentCategoryService.loadByCode("ICU"));
        department.setBudget(BigDecimal.valueOf(4000000.00));
        department.setUserManager(userService.loadById(Long.parseLong("5")));
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
        room.setUserManager(userService.loadById(Long.parseLong("5")));
        room.setArea(20.00f);
        room.setHeight(3.50f);
        room.setTemperature(22.0f);
        room.setIllumination(200);
        room.setAirChanges(20);
        room.setAirConditioning(true);
        room.setFloor("Lorem ipsum dolor sit amet magna. Praesent dolor. Maecenas mi vitae ornare dolor leo facilisis eget, lacinia quam molestie tincidunt. Pellentesque laoreet molestie tristique senectus.");
        room.setCeiling("Phasellus sagittis libero. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus nec ante. Maecenas interdum dui convallis at, imperdiet purus.");
        room.setWalls("Ut sodales, dictum libero, facilisis sem ullamcorper feugiat, pulvinar ligula.");
        room.setRemarks("Curabitur magna dictum sapien libero, id eleifend viverra. Cras enim sed eros. Etiam ac dolor. Morbi urna luctus aliquam, wisi vel leo. Cras lorem sapien, non dui. In mollis, metus. Nam vestibulum.");
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
        productService.addProductToRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("3")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("5")).getId(), room.getId());

        roomService.save(room);

        room = roomService.loadById(Long.valueOf("5"));
        productService.addProductToRoom(productService.loadById(Long.valueOf("1")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("2")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("3")).getId(), room.getId());
        productService.addProductToRoom(productService.loadById(Long.valueOf("3")).getId(), room.getId());

        roomService.save(room);
    }

    public void setInitDBTrue(
            HttpSession httpSession
    ) {
            InitTestDB.setInitDB(true);
            httpSession.setAttribute("initDB", true);
    }
}