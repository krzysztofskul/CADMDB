package pl.krzysztofskul.initTestDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.manufacturer.Manufacturer;
import pl.krzysztofskul.manufacturer.ManufacturerService;
import pl.krzysztofskul.organization.companyType.CompanyTypeService;
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
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class InitTestDBService {

    private CompanyTypeService companyTypeService;
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
            CompanyTypeService companyTypeService,
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
        this.companyTypeService = companyTypeService;
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

    public void saveCompanyTypes() {
        companyTypeService.createCompanyTypesAndSaveToDB();
    }

    public void saveInitTestUsersCategory() {
        for (UserCategory userCategory : InitTestDB.getInitTestDBInstance().createAndGetInitTestUserCategories()) {
            userCategoryService.save(userCategory);
        }
    }

    public void saveInitTestUsers() {
        for (User user : InitTestDB.getInitTestDBInstance().createAndGetInitTestUsers(userCategoryService.loadAll())) {
            userService.save(user);
        }
    }

    public void saveInitTestManufacturers() {
        List<Manufacturer> manufacturerInitList = InitTestDB.getInitTestDBInstance().createAndGetInitTestManufacturers(10);
        for (Manufacturer manufacturerInit : manufacturerInitList) {
            manufacturerService.save(manufacturerInit);
        }
    }

    public void saveInitTestProductsForTestManufacturers() {

        for(int i = 0; i < 4; i++) {
            Manufacturer manufacturer = manufacturerService.loadById(Long.parseLong(String.valueOf(i+1)));

            List<Product> productListAA0000 = InitTestDB.getInitTestDBInstance().createAndGetInitTestProducts(productCategoryService.loadByCode("AA0000"));
            List<Product> productListAB1000 = InitTestDB.getInitTestDBInstance().createAndGetInitTestProducts(productCategoryService.loadByCode("AB1000"));
            List<Product> productListAC1000 = InitTestDB.getInitTestDBInstance().createAndGetInitTestProducts(productCategoryService.loadByCode("AC1000"));
            List<Product> productListAH1000 = InitTestDB.getInitTestDBInstance().createAndGetInitTestProducts(productCategoryService.loadByCode("AH1000"));

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

    public void saveInitTestDepartmentCategoryList() {
        for (DepartmentCategory departmentCategory : InitTestDB.getInitTestDBInstance().createAndGetInitTestDepartmentCategoryList()) {
            departmentCategoryService.save(departmentCategory);
        }
    }

    public void saveInitTestHospitalsWithDepartmentsAndRooms() {
        for (Hospital hospital : InitTestDB.getInitTestDBInstance().createAndGetInitTestHospitals()) {
            addAndSaveInitTestDepartmentsToHospital(
                InitTestDB.getInitTestDBInstance().createAndGetInitTestDepartmentList(
                        departmentCategoryService.loadAll()
                ),
                hospital
            );
            for (Department department : hospital.getDepartmentList()) {
                addAndSaveInitTestRoomsToDepartment(
                    InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomList(
                            roomCategoryService.loadAll()
                    ),
                    department
                );
            }
            hospitalService.save(hospital);
        }
    }

    public void addAndSaveInitTestDepartmentsToHospital(List<Department> departmentList, Hospital hospital) {
        hospital.setDepartmentList(departmentList);
    }

    public void saveInitTestRoomCategoryList() {
        List<RoomCategory> roomCategoryList = InitTestDB.getInitTestDBInstance().createAndGetInitTestRoomCategoryList();

        for (RoomCategory roomCategory : roomCategoryList) {
            roomCategoryService.save(roomCategory);
        }

    }

    public void addAndSaveInitTestRoomsToDepartment(List<Room> roomList, Department department) {
        department.setRoomList(roomList);
    }

    public void addAndSaveHospitalsToInvestors() {
        List<User> investorList = userService.loadAllByUserCategoryEnum(UserCategoryEnum.INVESTOR);
        investorList.add(userService.loadByUserCategoryEnum(UserCategoryEnum.INVESTOR_GUEST));

        List<Hospital> hospitalList = hospitalService.loadAll();

        for (User investor : investorList) {
            for (int i = 0; i < 2; i++) {
                if (hospitalList.size() > 0  && null != hospitalList.get(0)) {
                    investor.addHospitalToHospitalsAsInvestor(hospitalList.get(0));
                    hospitalList.remove(0);
                }
            }
            userService.save(investor);
        }

    }

    public void addAndSaveUsersToHospitals() {
        User hospitalManagerGuestToAdd = userService.loadByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER_GUEST);
        Hospital hospitalForManagerGuest = hospitalService.loadById(Long.parseLong("1"));
        hospitalForManagerGuest.setManager(hospitalManagerGuestToAdd);
        hospitalService.save(hospitalForManagerGuest);

        List<User> hospitalManagerListToAdd = userService.loadAllByUserCategoryEnum(UserCategoryEnum.HOSPITAL_MANAGER);
        List<Hospital> hospitalList = hospitalService.loadAll();

        for (Hospital hospital : hospitalList) {
            if (hospital.getManager() == null) {
                if (hospitalManagerListToAdd.size() != 0) {
                    hospital.setManager(hospitalManagerListToAdd.get(0));
                    hospitalManagerListToAdd.remove(0);
                }
            }
            hospitalService.save(hospital);
        }

        List<User> hospitalEmployeeList = userService.loadAllByUserCategoryEnum(UserCategoryEnum.HOSPITAL_EMPLOYEE);
        for (User hospitalEmployeeGuest : userService.loadAllByUserCategoryEnum(UserCategoryEnum.HOSPITAL_EMPLOYEE_GUEST)) {
            hospitalEmployeeList.add(hospitalEmployeeGuest);
        }

        Hospital hospitalToAddEmployees = hospitalService.loadById(Long.parseLong("1"));
        hospitalToAddEmployees.setEmployeeList(hospitalEmployeeList);
        hospitalService.save(hospitalToAddEmployees);

    }

    public void createProductCategories() {
        ProductCategory productCategory;

        productCategory = new ProductCategory();
        productCategory.setCode("AA0000");
        productCategory.setNamePlural("HOSPITAL BEDS");
        productCategory.setNameSingular("HOSPITAL BED");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AB1000");
        productCategory.setNamePlural("OPERATING TABLES");
        productCategory.setNameSingular("OPERATING TABLE");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AC1000");
        productCategory.setNamePlural("OPERATING LIGHTS");
        productCategory.setNameSingular("OPERATING LIGHT");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE1000");
        productCategory.setNamePlural("MRI SYSTEMS");
        productCategory.setNameSingular("MRI SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE2010");
        productCategory.setNamePlural("SPECT SYSTEMS");
        productCategory.setNameSingular("SPECT SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE2020");
        productCategory.setNamePlural("PET SYSTEMS");
        productCategory.setNameSingular("PET SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3001");
        productCategory.setNamePlural("CT SYSTEMS");
        productCategory.setNameSingular("CT SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3000");
        productCategory.setNamePlural("X-RAY SYSTEMS");
        productCategory.setNameSingular("X-RAY SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE3001");
        productCategory.setNamePlural("CT SYSTEMS");
        productCategory.setNameSingular("CT SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AE7000");
        productCategory.setNamePlural("ULTRASOUND SYSTEMS");
        productCategory.setNameSingular("ULTRASOUND SYSTEM");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AH1000");
        productCategory.setNamePlural("ANAESTHETIC WORKSTATIONS");
        productCategory.setNameSingular("ANAESTHETIC WORKSTATION");
        productCategoryService.save(productCategory);

        productCategory = new ProductCategory();
        productCategory.setCode("AZ000");
        productCategory.setNamePlural("MEDICAL SUPPLY SYSTEMS");
        productCategory.setNameSingular("MEDICAL SUPPLY SYSTEM");
        productCategoryService.save(productCategory);

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

    public void addAndSaveInitTestProductsToRooms() {
        List<Room> roomList = roomService.loadAll();

        for (Room room : roomList) {
            if (room.getRoomCategory().getCode().equals("OR")) {
                List<Product> operatingTablesToAdd = productCategoryService.loadByCode("AB1000").getProductList();
                List<Product> operatingLampsToAdd = productCategoryService.loadByCode("AC1000").getProductList();
                List<Product> anaestheticWorkstationsToAdd = productCategoryService.loadByCode("AH1000").getProductList();
                if (!room.getProductList().containsAll(operatingTablesToAdd)) {
                    if (operatingTablesToAdd.size() != 0) {
                        room.addProduct(operatingTablesToAdd.get(new Random().nextInt(operatingTablesToAdd.size())));
                    }
                    if (operatingLampsToAdd.size() != 0) {
                        room.addProduct(operatingLampsToAdd.get(new Random().nextInt(operatingLampsToAdd.size())));
                    }
                    if (anaestheticWorkstationsToAdd.size() != 0) {
                        room.addProduct(anaestheticWorkstationsToAdd.get(new Random().nextInt(anaestheticWorkstationsToAdd.size())));
                    }
                }
            }
            roomService.save(room);
        }

    }

    public void setInitDBTrue(
            HttpSession httpSession
    ) {
            InitTestDB.setInitDB(true);
            httpSession.setAttribute("initDB", true);
    }
}